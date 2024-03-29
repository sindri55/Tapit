package work.sindri.tapit1.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import work.sindri.tapit1.EmvApplication;
import work.sindri.tapit1.R;
import work.sindri.tapit1.utils.ViewHolder;
import work.sindri.tapit1.utils.ViewUtils;

/**
 * Menu Adapter to display menu item
 * 
 * @author julien
 * 
 */
public class MenuDrawerAdapter extends BaseAdapter {

	//public List<Entry<Integer, String>> mData = new ArrayList<Map.Entry<Integer, String>>(7);
    public List<Entry<Integer, String>> mData = new ArrayList<Entry<Integer, String>>(6);

	private Context mContext;

	public MenuDrawerAdapter(final Context pContext) {
		mContext = pContext;
        /*
		mData.add(new AbstractMap.SimpleImmutableEntry<Integer, String>(R.drawable.ic_fa_credit_card, pContext.getResources()
				.getStringArray(R.array.navigation_items)[0]));
		mData.add(new AbstractMap.SimpleImmutableEntry<Integer, String>(R.drawable.ic_fa_gear, pContext.getResources()
				.getStringArray(R.array.navigation_items)[1]));
		mData.add(new AbstractMap.SimpleImmutableEntry<Integer, String>(R.drawable.ic_fa_info_circle, pContext.getResources()
				.getStringArray(R.array.navigation_items)[2]));
		mData.add(new AbstractMap.SimpleImmutableEntry<Integer, String>(R.drawable.ic_fa_info_circle, pContext.getResources()
				.getStringArray(R.array.navigation_items)[3]));
		mData.add(new AbstractMap.SimpleImmutableEntry<Integer, String>(R.drawable.ic_fa_info_circle, pContext.getResources()
				.getStringArray(R.array.navigation_items)[4]));
		mData.add(new AbstractMap.SimpleImmutableEntry<Integer, String>(R.drawable.ic_fa_info_circle, pContext.getResources()
				.getStringArray(R.array.navigation_items)[5]));
		mData.add(new AbstractMap.SimpleImmutableEntry<Integer, String>(R.drawable.ic_fa_info_circle, pContext.getResources()
				.getStringArray(R.array.navigation_items)[6])); */
        mData.add(new AbstractMap.SimpleImmutableEntry<Integer, String>(R.drawable.ic_fa_gear, pContext.getResources()
                .getStringArray(R.array.navigation_items)[0]));
        mData.add(new AbstractMap.SimpleImmutableEntry<Integer, String>(R.drawable.ic_fa_info_circle, pContext.getResources()
                .getStringArray(R.array.navigation_items)[1]));
        mData.add(new AbstractMap.SimpleImmutableEntry<Integer, String>(R.drawable.ic_fa_info_circle, pContext.getResources()
                .getStringArray(R.array.navigation_items)[2]));
        mData.add(new AbstractMap.SimpleImmutableEntry<Integer, String>(R.drawable.ic_fa_info_circle, pContext.getResources()
                .getStringArray(R.array.navigation_items)[3]));
        mData.add(new AbstractMap.SimpleImmutableEntry<Integer, String>(R.drawable.ic_fa_info_circle, pContext.getResources()
                .getStringArray(R.array.navigation_items)[4]));
        mData.add(new AbstractMap.SimpleImmutableEntry<Integer, String>(R.drawable.ic_fa_info_circle, pContext.getResources()
                .getStringArray(R.array.navigation_items)[5]));
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public Object getItem(final int position) {
		return mData.get(position);
	}

	@Override
	public long getItemId(final int position) {
		return position;
	}

	@Override
	public View getView(final int position, final View convertView, final ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			v = View.inflate(mContext, R.layout.drawer_listview_item, null);
		}
		// get view from holder
		TextView menuText = ViewHolder.get(v, R.id.menu_item_text);
		ImageView menuIcon = ViewHolder.get(v, R.id.menu_item_icon);


		ListView mDrawerListView;
		// Get element
		@SuppressWarnings("unchecked")
		Entry<Integer, String> data = (Entry<Integer, String>) getItem(position);

		menuIcon.setImageResource(data.getKey());
		menuText.setText(data.getValue());

		// Apply faceType
		ViewUtils.setTypeFace(EmvApplication.sTypeface, menuText);

		return v;
	}

}
