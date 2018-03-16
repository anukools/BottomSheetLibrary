package in.anukool.colorfulbottomsheetlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;

import in.anukool.bottomsheet.BottomTabSheet;

public class MainActivity extends AppCompatActivity {

    BottomTabSheet bottomTabSheet;
    
    int container;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = R.id.container;

        //Setup button tab layout
        bottomTabSheet = (BottomTabSheet) findViewById(R.id.bottomTabSheet);
        //set button text style
        bottomTabSheet.setButtonTextStyle(R.style.TextGray12);
        // set buttons from menu resource
        bottomTabSheet.setItems(R.menu.menu);
        //set on selected tab listener.
        bottomTabSheet.setListener(new BottomTabSheet.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                switchFragment(id);
            }
        });
        //set button that will be select on start activity
        bottomTabSheet.setSelectedTab(R.id.menu_button1);
        //enable indicator
        bottomTabSheet.setIndicatorVisible(true);
        //indicator height
        bottomTabSheet.setIndicatorHeight(getResources().getDimension(R.dimen.indicator_height));
        //indicator color
        bottomTabSheet.setIndicatorColor(R.color.green);
        //indicator line color
        bottomTabSheet.setIndicatorLineColor(R.color.dark);
        bottomTabSheet.setSelectedTab(R.id.menu_button5);

        //setup bubble style
        bottomTabSheet.setTabBubbleColor(ContextCompat.getColor(this, R.color.blue));
        bottomTabSheet.setTabBubblePadding(0, 0, 0, 0);
        bottomTabSheet.setTabBubbleTextStyle(R.style.TextWhite12);

        //show bubble
        bottomTabSheet.showTabBubbleCount(R.id.menu_button1, 3);


    }

    /**
     * Show fragment in container
     *
     * @param id Menu item res id
     */
    public void switchFragment(int id) {
        Fragment fragment = null;
        switch (id) {
            case R.id.menu_button1:
                fragment = TabFragment.newInstance(R.color.blue, "Fragment 1");
                break;
            case R.id.menu_button2:
                fragment = TabFragment.newInstance(R.color.green, "Fragment 2");
                break;
            case R.id.menu_button3:
                fragment = TabFragment.newInstance(R.color.pink, "Fragment 3");
                break;
            case R.id.menu_button4:
                fragment = TabFragment.newInstance(R.color.blueDark, "Fragment 4");
                break;
            case R.id.menu_button5:
                fragment = TabFragment.newInstance(R.color.white, "Fragment 5");
                break;
        }
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(container, fragment);
            transaction.commit();
        }
    }
}
