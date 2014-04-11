package com.claytobolka.explorerapp.navigationDrawer;

/**
 * Created by tobolkac on 3/3/14.
 */
public class NavigationDrawerItem {

    private int icon;
    private String title;
    private String count = "0";
    private boolean isCounterVisible = false;

    public NavigationDrawerItem()
    {

    }

    public NavigationDrawerItem(String title, int icon)
    {
        this.title = title;
        this.icon = icon;
    }

    public NavigationDrawerItem(String title, int icon, boolean isCounterVisible, String count)
    {
        this.title = title;
        this.icon = icon;
        this.isCounterVisible = isCounterVisible;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCounterVisible() {
        return isCounterVisible;
    }

    public void setCounterVisible(boolean isCounterVisible) {
        this.isCounterVisible = isCounterVisible;
    }

    public String getCount() {

        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public int getIcon() {

        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

}
