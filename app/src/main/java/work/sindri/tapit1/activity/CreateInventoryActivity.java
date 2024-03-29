package work.sindri.tapit1.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Handler;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import work.sindri.tapit1.R;
import work.sindri.tapit1.adapter.ListViewCreateInventoryAdapter;
import work.sindri.tapit1.adapter.MenuDrawerAdapter;
import work.sindri.tapit1.fragment.AboutFragment;
import work.sindri.tapit1.fragment.BillingFragment;
import work.sindri.tapit1.fragment.CartFragment;
import work.sindri.tapit1.fragment.CreateInventoryFragment;
import work.sindri.tapit1.fragment.FundraiserFragment;
import work.sindri.tapit1.fragment.IRefreshable;
import work.sindri.tapit1.fragment.LogOutFragment;
import work.sindri.tapit1.fragment.SimplePayFragment;
import work.sindri.tapit1.utils.ConstantUtils;
import work.sindri.tapit1.utils.CroutonUtils;

/**
 * Created by Ragnar on 13.5.2015.
 */



public class CreateInventoryActivity extends FragmentActivity implements AdapterView.OnItemClickListener{

    /**
     * last selected Menu
     */
    private int mLastSelectedMenu = -1;
    /**
     * Reference for refreshable content
     */
    private WeakReference<IRefreshable> mRefreshableContent;
    /**
     * Action bar drawer toggle
     */
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    /**
     * Drawer layout
     */
    private DrawerLayout mDrawerLayout;

    /**
     * Menu adapter
     */
    private MenuDrawerAdapter mMenuAdapter;


    /**
     * ListView drawer
     */
    private ListView mDrawerListView;



    ArrayList<String> listItems;
    ListViewCreateInventoryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        listItems = new ArrayList<String>();
        //prices = new ArrayList<Integer>();
        //quantities = new ArrayList<Integer>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_inventory);

        //Setting up the adapter for the listview.. (list)..
        adapter = new ListViewCreateInventoryAdapter(listItems, this);
        ListView lwCreateInventoryList = (ListView) findViewById(R.id.create_inventory_list);
        lwCreateInventoryList.setBackgroundColor(getResources().getColor(R.color.valitor_lightorange));
        lwCreateInventoryList.setAdapter(adapter);
        //setListAdapter(adapter);


        /* Sidebar menu */
        // get ListView defined in activity_main.xml
        mDrawerListView = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mMenuAdapter = new MenuDrawerAdapter(this);
        mDrawerListView.setAdapter(mMenuAdapter);
        mDrawerListView.setOnItemClickListener(this);

        // 2. App Icon
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // 2.1 create ActionBarDrawerToggle
        mActionBarDrawerToggle = new ActionBarDrawerToggle(/* */
                this, /* host Activity */
                mDrawerLayout, /* DrawerLayout object */
                R.drawable.ic_drawer, /* nav drawer icon to replace 'Up' caret */
                R.string.navigation_menu_open, /* "open drawer" description */
                R.string.navigation_menu_close /* "close drawer" description */
        );

        // 2.2 Set actionBarDrawerToggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayUseLogoEnabled(false);
        getActionBar().setDisplayShowCustomEnabled(true);

    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, SimplePayActivity.class);
        startActivity(intent);
        CreateInventoryActivity.this.finish();
    }


    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        if (mLastSelectedMenu == ConstantUtils.ABOUT) {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.content_frame);
            if (fragment != null) {
                BillingFragment billing = (BillingFragment) fragment.getChildFragmentManager().findFragmentById(R.id.about_inapp_content);
                if (billing != null) {
                    billing.onActivityResult(requestCode, resultCode, data);
                }
            }
        }
    }
/*
    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (mActionBarDrawerToggle.onOptionsItemSelected(item)) {
            Crouton.cancelAllCroutons();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
*/

    @Override
    public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
        if (mLastSelectedMenu != position) {
            Fragment fragment = null;
            switch (position) {
                /*
                case ConstantUtils.CARDS_DETAILS:
                    fragment = new ViewPagerFragment();
                    refreshContent();
                    break; */
                case ConstantUtils.SIMPLEPAY:
                    fragment = new SimplePayFragment();
                    break;
                case ConstantUtils.CART:
                    fragment = new CartFragment();
                    break;
                case ConstantUtils.INVERTORY:
                    fragment = new CreateInventoryFragment();
                    break;
                case ConstantUtils.FUNDRAISER:
                    fragment = new FundraiserFragment();
                    break;
                case ConstantUtils.ABOUT:
                    fragment = new AboutFragment();
                    break;
                case ConstantUtils.LOGOUT:
                    fragment = new LogOutFragment();
                    break;
                default:
                    break;
            }
            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
            mLastSelectedMenu = position;
        }
        mDrawerLayout.closeDrawer(mDrawerListView);
    }

    private void refreshContent() {
        if (mRefreshableContent != null && mRefreshableContent.get() != null) {
            mRefreshableContent.get().update();
        }
    }


    public void addToList(View view) {
        EditText name = (EditText) findViewById(R.id.edit_name);
        EditText price = (EditText) findViewById(R.id.edit_price);
        listItems.add(name.getText().toString() + " " + price.getText().toString());
        adapter.notifyDataSetChanged();
        price.setText("");
        name.setText("");
    }

    public void saveList(View view) {

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                CroutonUtils.display(CreateInventoryActivity.this, "Listi vistaður", CroutonUtils.CoutonColor.GREEN);


            }
        }, 1000);

        Context context = getApplicationContext();
        CharSequence text = "List saved";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        final Context outerContext = this;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(outerContext, CartActivity.class);
                startActivity(i);
                CreateInventoryActivity.this.finish();

            }
        }, 1500);
    }




}
