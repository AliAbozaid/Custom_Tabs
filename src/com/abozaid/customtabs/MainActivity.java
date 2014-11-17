package com.abozaid.customtabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends ActionBarActivity {

	private static final int NUM_PAGES = 5;
	private ViewPager mPager;
	private PagerAdapter mPagerAdapter;
	Context context;
	ImageView timeline_img, profile_img, notification_img, add7asana_img,
			settings_img;
	View sep1, sep2, sep3, sep4;
	static int pos;
	LinearLayout timeline_lay, profile_lay, notifcation_lay, settings_lay;
	// JobManagerSingletone jobManager;
	static SharedPreferences UserInformation;
	static SharedPreferences.Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ActionBar actionBar = getSupportActionBar();
		actionBar.hide();

		context = this;

		timeline_lay = (LinearLayout) findViewById(R.id.timeline_lay);
		profile_lay = (LinearLayout) findViewById(R.id.profile_lay);
		notifcation_lay = (LinearLayout) findViewById(R.id.notifcation_lay);
		settings_lay = (LinearLayout) findViewById(R.id.settings_lay);
		timeline_img = (ImageView) findViewById(R.id.timeline);
		profile_img = (ImageView) findViewById(R.id.profile);
		notification_img = (ImageView) findViewById(R.id.notifcation);
		add7asana_img = (ImageView) findViewById(R.id.circle);
		settings_img = (ImageView) findViewById(R.id.setting);

		pos = 0;

		sep1 = findViewById(R.id.separator1);
		sep2 = findViewById(R.id.separator2);
		sep3 = findViewById(R.id.separator3);
		sep4 = findViewById(R.id.separator4);
		SelectedImage(pos);

		mPager = (ViewPager) findViewById(R.id.pager);
		mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
		mPager.setAdapter(mPagerAdapter);

		mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				// When changing pages, reset the action bar actions since they
				// are dependent
				// on which page is currently active. An alternative approach is
				// to have each
				// fragment expose actions itself (rather than the activity
				// exposing actions),
				// but for simplicity, the activity provides the actions in this
				// sample.

				// get action data
				mPager.setOffscreenPageLimit(5);
				pos = position;
				if (position == 0) {
					// notification.setImageResource(R.drawable.notifcationline);
					SelectedImage(position);
				} else if (position == 1) {
					SelectedImage(position);
				} else if (position == 2) {
					SelectedImage(position);
				} else if (position == 3) {
					SelectedImage(position);
				} else if (position == 4) {
					SelectedImage(position);
				} else {

				}

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}
		});

		timeline_lay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SelectedImage(pos);
				mPager.setCurrentItem(0);

			}
		});
		profile_lay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SelectedImage(pos);
				mPager.setCurrentItem(1);

			}
		});
		add7asana_img.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SelectedImage(pos);
				mPager.setCurrentItem(2);
			}
		});
		notifcation_lay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SelectedImage(pos);
				mPager.setCurrentItem(3);

			}
		});
		settings_lay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SelectedImage(pos);
				mPager.setCurrentItem(4);

			}
		});
	}

	public void SelectedImage(int Position) {
		// Do something here
		switch (Position) {
		case 0:
			sep1.setVisibility(View.VISIBLE);
			sep2.setVisibility(View.INVISIBLE);
			sep3.setVisibility(View.INVISIBLE);
			sep4.setVisibility(View.INVISIBLE);
			// selected
			timeline_img.setImageResource(R.drawable.timelineselected);
			// unselected
			profile_img.setImageResource(R.drawable.profile);
			add7asana_img.setImageResource(R.drawable.hsna);
			notification_img.setImageResource(R.drawable.notifcation);
			settings_img.setImageResource(R.drawable.setting);
			break;
		case 1:
			sep2.setVisibility(View.VISIBLE);
			sep1.setVisibility(View.INVISIBLE);
			sep3.setVisibility(View.INVISIBLE);
			sep4.setVisibility(View.INVISIBLE);
			// selected
			profile_img.setImageResource(R.drawable.profileselected);
			// unselected
			timeline_img.setImageResource(R.drawable.timeline);
			add7asana_img.setImageResource(R.drawable.hsna);
			notification_img.setImageResource(R.drawable.notifcation);
			settings_img.setImageResource(R.drawable.setting);
			break;
		case 2:
			sep1.setVisibility(View.INVISIBLE);
			sep2.setVisibility(View.INVISIBLE);
			sep3.setVisibility(View.INVISIBLE);
			sep4.setVisibility(View.INVISIBLE);
			// selected
			add7asana_img.setImageResource(R.drawable.hsnaselected);
			// unselected
			timeline_img.setImageResource(R.drawable.timeline);
			profile_img.setImageResource(R.drawable.profile);
			notification_img.setImageResource(R.drawable.notifcation);
			settings_img.setImageResource(R.drawable.setting);
			break;
		case 3:
			sep3.setVisibility(View.VISIBLE);
			sep1.setVisibility(View.INVISIBLE);
			sep2.setVisibility(View.INVISIBLE);
			sep4.setVisibility(View.INVISIBLE);
			// selected
			notification_img.setImageResource(R.drawable.notifcationselected);
			// unselected
			timeline_img.setImageResource(R.drawable.timeline);
			profile_img.setImageResource(R.drawable.profile);
			add7asana_img.setImageResource(R.drawable.hsna);
			settings_img.setImageResource(R.drawable.setting);
			break;
		case 4:
			sep4.setVisibility(View.VISIBLE);
			sep1.setVisibility(View.INVISIBLE);
			sep2.setVisibility(View.INVISIBLE);
			sep3.setVisibility(View.INVISIBLE);
			// selected
			settings_img.setImageResource(R.drawable.settingselected);
			// unselected
			timeline_img.setImageResource(R.drawable.timeline);
			profile_img.setImageResource(R.drawable.profile);
			add7asana_img.setImageResource(R.drawable.hsna);
			notification_img.setImageResource(R.drawable.notifcation);
			break;
		default:
			break;
		}
	}

	private class ScreenSlidePagerAdapter extends FragmentPagerAdapter {
		public ScreenSlidePagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// this where i will update
			// return ScreenSlidePageFragment.create(position);
			// return
			// ScreenSlidePageFragment.newInstance("");//AddNatureDiapper.newInstance("");
			if (position == 0) {
				// return TimeLine.newInstance(context);
				return ScreenSlidePageFragment.newInstance("");
			} else if (position == 1) {
				return ScreenSlidePageFragment.newInstance("");
			} else if (position == 2) {
				return ScreenSlidePageFragment.newInstance("");
			} else if (position == 3) {
				return ScreenSlidePageFragment.newInstance("");
			} else if (position == 4) {
				return ScreenSlidePageFragment.newInstance("");
			} else {
				return ScreenSlidePageFragment.newInstance("");
			}
		}

		@Override
		public int getCount() {
			return NUM_PAGES;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
