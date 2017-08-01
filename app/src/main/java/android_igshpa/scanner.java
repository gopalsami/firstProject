package com.example.srivallikanchibotla.android_igshpa;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentProviderOperation;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.CoordinatorLayout;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.google.zxing.Result;
import org.json.JSONObject;
import android.content.pm.PackageManager;
import android.content.ContentProviderResult;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;
import java.util.ArrayList;

import me.dm7.barcodescanner.zxing.ZXingScannerView;



public class scanner extends Activity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView zXingScannerView;
    private static final String TAG = "scanner";
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;
    private static final int REQUEST_CAMERA = 5;
    private CoordinatorLayout coordinatorLayout;
    private CoordinatorLayout coordinatorLayout1;
    String Firstname = "";
    String Lastname = "";
    String MobileNumber = "";
    String HomeNumber = "";
    String emailID = "";
    String company = "";
    String jobTitle = "";
    String note = "";
    String address = "";
    String state = "";
    String city = "";
    String zip = "";
    String country1 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        }else {
            zXingScannerView = new ZXingScannerView(getApplicationContext());
            setContentView(zXingScannerView);
            zXingScannerView.setResultHandler(this);
            zXingScannerView.startCamera();
        }
    }

    public void scan(View view) {
        //checkForPermissionCamera();
        zXingScannerView = new ZXingScannerView(getApplicationContext());
        setContentView(zXingScannerView);
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        zXingScannerView.resumeCameraPreview(scanner.this);
    }

    @Override
    public void onBackPressed() {
        Intent confView = new Intent(getBaseContext(), conferences.class);
        startActivity(confView);
    }

    @Override
    public void onPause() {
        super.onPause();
       // onBackPressed();
    }

    @Override
    public void handleResult(final Result rawResult) {
        // Do something with the result here
        Log.e("handler", rawResult.getText()); // Prints scan results
        String str = rawResult.getText().toString();

        try {
            JSONObject obj = new JSONObject(str);
            Firstname = obj.getString("firstName");
            Lastname = obj.getString("lastName");
            MobileNumber = obj.getString("phone1");
            HomeNumber = obj.getString("phone2");
            emailID = obj.getString("email");
            company = obj.getString("company");
            jobTitle = obj.getString("title");
            note = obj.getString("attendeeType");
            address = obj.getString("address");
            state = obj.getString("state");
            city = obj.getString("city");
            zip = obj.getString("zip");
            country1 = obj.getString("country");
        } catch (Exception e) {
            e.printStackTrace();
        }

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(scanner.this);

        // Setting Dialog Title
        alertDialog.setTitle("Add Contact");

        // Setting Dialog Message
        alertDialog.setMessage("Would you like to save" +" "+ Firstname +" " + "to your Contacts");
        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        // Write your code here to execute after dialog
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
                            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
                        } else {
                            addContact();
                            zXingScannerView.resumeCameraPreview(scanner.this);
                        }

                    }
                });
        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        Toast.makeText(getApplicationContext(), "Contact not saved", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                        zXingScannerView.resumeCameraPreview(scanner.this);
                    }
                });

        // Showing Alert Message
        alertDialog.show();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS ) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                // Permission is granted
                addContact();
            } else {
                Toast.makeText(this, "Until you grant the permission, we canot display the names", Toast.LENGTH_SHORT).show();
            }
        }else if (requestCode == REQUEST_CAMERA) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                // Permission is granted
                zXingScannerView = new ZXingScannerView(getApplicationContext());
                setContentView(zXingScannerView);
                zXingScannerView.setResultHandler(this);
                zXingScannerView.startCamera();
            } else {
                Toast.makeText(this, "Until you grant the permission, we cannot display the scanner", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void addContact() {

            ArrayList<ContentProviderOperation> op_list = new ArrayList<ContentProviderOperation>();
            if (Firstname != ""  && Lastname != "" ) {
                op_list.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
                        .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                        .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
                        .build());

                // first and last names
                op_list.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
                        .withValueBackReference(Data.RAW_CONTACT_ID, 0)
                        .withValue(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE)
                        .withValue(StructuredName.GIVEN_NAME, Firstname)
                        .withValue(StructuredName.FAMILY_NAME, Lastname)

                        .build());

                op_list.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
                        .withValueBackReference(Data.RAW_CONTACT_ID, 0)
                        .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                        .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER,HomeNumber )
                        .withValue(ContactsContract.CommonDataKinds.Phone.TYPE, Phone.TYPE_HOME)
                        .build());
                op_list.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
                        .withValueBackReference(Data.RAW_CONTACT_ID, 0)
                        .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                        .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, MobileNumber)
                        .withValue(ContactsContract.CommonDataKinds.Phone.TYPE, Phone.TYPE_MOBILE)
                        .build());

                op_list.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
                        .withValueBackReference(Data.RAW_CONTACT_ID, 0)
                        .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)
                        .withValue(ContactsContract.CommonDataKinds.Email.DATA, emailID)
                        .withValue(ContactsContract.CommonDataKinds.Email.TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                        .build());
                op_list.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
                        .withValueBackReference(Data.RAW_CONTACT_ID, 0)
                        .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Note.CONTENT_ITEM_TYPE)
                        .withValue(ContactsContract.CommonDataKinds.Note.NOTE, note)
                        .build());
                op_list.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
                        .withValueBackReference(Data.RAW_CONTACT_ID, 0)
                        .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Organization.CONTENT_ITEM_TYPE)
                        .withValue(ContactsContract.CommonDataKinds.Organization.COMPANY, company)
                        .withValue(ContactsContract.CommonDataKinds.Organization.TITLE, jobTitle)
                        .build());
                op_list.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
                        .withValueBackReference(Data.RAW_CONTACT_ID, 0)
                        .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE)
                        .withValue(ContactsContract.CommonDataKinds.StructuredPostal.STREET, address)

                        .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE)
                        .withValue(ContactsContract.CommonDataKinds.StructuredPostal.CITY, city)

                        .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE)
                        .withValue(ContactsContract.CommonDataKinds.StructuredPostal.POSTCODE, zip)

                        .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE)
                        .withValue(ContactsContract.CommonDataKinds.StructuredPostal.COUNTRY, country1)

                        .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE)
                        .withValue(ContactsContract.CommonDataKinds.StructuredPostal.REGION, state)

                        .build());
                if (MobileNumber.contentEquals("")) {
                    try {
                        //contactExists(this, MobileNumber);

                        ContentProviderResult[] results = getContentResolver().applyBatch(ContactsContract.AUTHORITY, op_list);
                        Toast.makeText(getApplicationContext(), "Contact saved", Toast.LENGTH_SHORT).show();
                        zXingScannerView.resumeCameraPreview(scanner.this);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        //contactExists(this, MobileNumber);
                        if (isContact(MobileNumber)) {
                            ContentProviderResult[] results = getContentResolver().applyBatch(ContactsContract.AUTHORITY, op_list);
                            Toast.makeText(getApplicationContext(), "Contact saved", Toast.LENGTH_SHORT).show();
                            zXingScannerView.resumeCameraPreview(scanner.this);
                        } else {
                            Toast.makeText(getApplicationContext(), "Contact already exists", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                Toast.makeText(getApplicationContext(), "Wrong QR Code Detected", Toast.LENGTH_SHORT).show();
                zXingScannerView.resumeCameraPreview(scanner.this);
            }
        }
    private boolean isContact(String incommingNumber) {
        Cursor cursor =null;
        String name = null;
            try {
                Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(incommingNumber));
                cursor = scanner.this.getContentResolver().query(uri, new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME}, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    name = cursor.getString(cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME));
                    return false;
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
            if (name != null) {
                return false;
            } else {
                return true;
            }
    }
}
