package com.example.chiranshu.p10;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.chiranshu.p10.data.i_Contract;

/**
 * Created by chiranshu on 09-05-2017.
 */
public class data_recieving extends AppCompatActivity  implements LoaderManager.LoaderCallbacks<Cursor>{

    public Uri mCurrentUri;
    Uri img_uri;
    public EditText p_mail;
    public EditText p_name;
    public EditText p_quantity;
    public EditText p_price;
    public Button add_img;
    public ImageView p_image;
    public  boolean p_nameHasChanged;
    static final int IMG_ID = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_recieving);
        final int EXISTING_I_LOADER = 0;

        View.OnTouchListener mTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                p_nameHasChanged = true;
                return false;
            }
        };

        Intent intent = getIntent();
        mCurrentUri = intent.getData();

        if (mCurrentUri == null) {
            setTitle(getString(R.string.add_product));
            invalidateOptionsMenu();
        } else {
            setTitle(getString(R.string.edit_product));
            getLoaderManager().initLoader(EXISTING_I_LOADER, null, this);
        }

        p_name = (EditText) findViewById(R.id.p_name);
        p_quantity = (EditText) findViewById(R.id.p_quantity);
        p_mail = (EditText) findViewById(R.id.mail);
        add_img = (Button) findViewById(R.id.add_img);
        p_price = (EditText) findViewById(R.id.p_price);
        p_image = (ImageView) findViewById(R.id.product_image);



        p_name.setOnTouchListener(mTouchListener);
        p_quantity.setOnTouchListener(mTouchListener);
        p_mail.setOnTouchListener(mTouchListener);
        add_img.setOnTouchListener(mTouchListener);
        p_price.setOnTouchListener(mTouchListener);

        add_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("IMAGE/*");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, IMG_ID);
                }
            }
        });}
    private void saveProducts() {
        String name= p_name.getText().toString().trim();
        String quantity= p_quantity.getText().toString().trim();
        String price = p_price.getText().toString().trim();
        String image="";
        if (img_uri != null) {
            image = img_uri.toString();
        }
        String email=p_mail.getText().toString().trim();

        if (mCurrentUri == null &&
                TextUtils.isEmpty(name) || TextUtils.isEmpty(quantity) ||
                TextUtils.isEmpty(price)  ||     TextUtils.isEmpty(email) ||
                TextUtils.isEmpty(image)){
            return;
        }

        int quantity1 = 0;
        if (!TextUtils.isEmpty(quantity)) {
            quantity1 = Integer.parseInt(quantity);
        }
        int PRICE1 = 0;
        if (!TextUtils.isEmpty(price)) {
            PRICE1 = Integer.parseInt(price);
        }
        ContentValues values = new ContentValues();
        values.put(i_Contract.I_Entry.COLUMN_I_NAME, name);
        values.put(i_Contract.I_Entry.COLUMN_I_QUANTITY, quantity1);
        values.put(i_Contract.I_Entry.COLUMN_I_PRICE, PRICE1);
        values.put(i_Contract.I_Entry.COLUMN_I_IMAGE, image);
        values.put(i_Contract.I_Entry.COLUMN_I_MAIL, email);

        if (mCurrentUri == null) {
            Uri newUri = getContentResolver().insert(i_Contract.I_Entry.CONTENT_URI, values);

            if (newUri == null) {
                Toast.makeText(this, getString(R.string.insert_failed),
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            int rowsAffected = getContentResolver().update(mCurrentUri, values, null, null);

            if (rowsAffected == 0) {
                Toast.makeText(this, getString(R.string.update_failed),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (mCurrentUri == null) {
            MenuItem itemDel = menu.findItem(R.id.action_delete);
            MenuItem itemOrder = menu.findItem(R.id.action_order);
            itemDel.setVisible(false);
            itemOrder.setVisible(false);
        }
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                saveProducts();
                finish();
                return true;
            case R.id.action_delete:
                showDeleteConfirmationDialog();
                return true;
            case R.id.action_order:
                String pName = p_name.getText().toString();
                String pEmail = p_mail.getText().toString();
                String pQuantity = p_quantity.getText().toString();

                String subj="ORDER";
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + pEmail));
                intent.putExtra(Intent.EXTRA_SUBJECT,"ABOUT INVENTORY APP ORDER");
                intent.putExtra(Intent.EXTRA_TEXT, "INVENTORY APP:\n" +"\n"+"Product " + pName + "\n" + "Quantity " + pQuantity );

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                return true;
            case android.R.id.home:
                if (!p_nameHasChanged) {
                    NavUtils.navigateUpFromSameTask(data_recieving.this);
                    return true;
                }

                DialogInterface.OnClickListener discardButtonClickListener =
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                NavUtils.navigateUpFromSameTask(data_recieving.this);
                            }
                        };
                showUnsavedChangesDialog(discardButtonClickListener);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        if (!p_nameHasChanged) {
            super.onBackPressed();
            return;
        }

        DialogInterface.OnClickListener discardButtonClickListener =
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                };

        showUnsavedChangesDialog(discardButtonClickListener);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] projection = {
                i_Contract.I_Entry._ID,
                i_Contract.I_Entry.COLUMN_I_NAME,
                i_Contract.I_Entry.COLUMN_I_QUANTITY,
                i_Contract.I_Entry.COLUMN_I_PRICE,
                i_Contract.I_Entry.COLUMN_I_MAIL,
                i_Contract.I_Entry.COLUMN_I_IMAGE };

        return new CursorLoader(this,  mCurrentUri, projection,   null,     null,   null);   }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {
            int name_C_i = cursor.getColumnIndex(i_Contract.I_Entry.COLUMN_I_NAME);
            int s_price_C_i = cursor.getColumnIndex(i_Contract.I_Entry.COLUMN_I_PRICE);
            int s_mail_C_i = cursor.getColumnIndex(i_Contract.I_Entry.COLUMN_I_MAIL);
            int s_quantity_C_i = cursor.getColumnIndex(i_Contract.I_Entry.COLUMN_I_QUANTITY);
            int image_C_i = cursor.getColumnIndex(i_Contract.I_Entry.COLUMN_I_IMAGE);
            String s_name = cursor.getString(name_C_i);
            int s_quantity = cursor.getInt(s_quantity_C_i);
            int s_price = cursor.getInt(s_price_C_i);
            String s_mail = cursor.getString(s_mail_C_i);

            String imageUri = cursor.getString(image_C_i);
            if (imageUri.startsWith("content://com.android.providers.media.documents/document/image")) {
                p_image.setImageURI(Uri.parse(imageUri));
            } else {
                p_image.setImageResource(R.drawable.product);
            }
            p_name.setText(s_name);
            p_price.setText(Integer.toString(s_price));
            p_mail.setText((s_mail));
            p_quantity.setText(Integer.toString(s_quantity));

        }}
    @Override
    public void onLoaderReset(Loader<Cursor> loader){
        p_name.setText("");
        p_price.setText("");
        p_mail.setText("");
        p_quantity.setText("");
    }
    private void showUnsavedChangesDialog(
            DialogInterface.OnClickListener discardButtonClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.unsaved_changes_dialog_msg);
        builder.setPositiveButton(R.string.discard, discardButtonClickListener);
        builder.setNegativeButton(R.string.keep_editing, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void showDeleteConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.delete_dialog_msg);
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                deleteproduct();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void deleteproduct() {
        if (mCurrentUri != null) {
            int rowsDeleted = getContentResolver().delete(mCurrentUri, null, null);

            if (rowsDeleted == 0) {
                Toast.makeText(this, getString(R.string.editor_delete_product_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.editor_delete_product_successful),
                        Toast.LENGTH_SHORT).show();
            }
        }
        finish();
    }

    public void increment(View view) {
        if (!p_quantity.getText().toString().equals("")){
            int quantity = Integer.parseInt(p_quantity.getText().toString());
            quantity++;
            p_quantity.setText(String.valueOf(quantity));
        }

    }

    public void decrement(View view) {
        if (!p_quantity.getText().toString().equals("") && !p_quantity.getText().toString().equals("0")){
            int quantity = Integer.parseInt(p_quantity.getText().toString());
            if(quantity<=0)
            {
                Toast.makeText(getBaseContext(), "Quantity Cannot be less than Zero, So value is set to 0", Toast.LENGTH_SHORT).show();
                return;
            }
            quantity--;
            p_quantity.setText(String.valueOf(quantity));
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (requestCode == IMG_ID && resultCode == RESULT_OK) {
            img_uri = data.getData();
            p_image.setImageURI(img_uri);
            String ID = DocumentsContract.getDocumentId(Uri.parse(String.valueOf(img_uri)));
            String sId = ID.split(":")[1];
            String[] col = {MediaStore.Images.Media.DATA};
            String sel = MediaStore.Images.Media._ID + "=?";
            Cursor cursor = getContentResolver().
                    query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                            col, sel, new String[]{sId}, null);

            cursor.close();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}