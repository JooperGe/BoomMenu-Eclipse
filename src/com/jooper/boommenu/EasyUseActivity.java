package com.jooper.boommenu;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.jooper.boommenu.Types.BoomType;
import com.jooper.boommenu.Types.ButtonType;
import com.jooper.boommenu.Types.PlaceType;

public class EasyUseActivity extends Activity {

	private boolean init = false;
	private BoomMenuButton boomMenuButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_easy_use);

		boomMenuButton = (BoomMenuButton) findViewById(R.id.boom);
	}

	/**
	 * Init the boom menu button. Notice that you should call this NOT in your
	 * onCreate method. Because the width and height of boom menu button is 0.
	 * Call this in:
	 *
	 * @Override public void onWindowFocusChanged(boolean hasFocus) {
	 *           super.onWindowFocusChanged(hasFocus); init(...); }
	 *
	 */
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);

		// Use a param to record whether the boom button has been initialized
		// Because we don't need to init it again when onResume()
		if (init)
			return;
		init = true;

		Drawable[] subButtonDrawables = new Drawable[3];
		int[] drawablesResource = new int[] { R.drawable.boom, R.drawable.java,
				R.drawable.github };
		for (int i = 0; i < 3; i++)

			subButtonDrawables[i] = getResources().getDrawable(
					drawablesResource[i]);

		String[] subButtonTexts = new String[] { "BoomMenuButton",
				"View source code", "Follow me" };

		int[][] subButtonColors = new int[3][2];
		for (int i = 0; i < 3; i++) {

			subButtonColors[i][1] = getResources().getColor(
					R.color.material_white);
			subButtonColors[i][0] = Util.getInstance().getPressedColor(
					subButtonColors[i][1]);
		}

		boomMenuButton.init(subButtonDrawables, // The drawables of images of
												// sub buttons. Can not be null.
				subButtonTexts, // The texts of sub buttons, ok to be null.
				subButtonColors, // The colors of sub buttons, including
									// pressed-state and normal-state.
				ButtonType.HAM, // The button type.
				BoomType.PARABOLA, // The boom type.
				PlaceType.HAM_3_1, // The place type.
				null, // Ease type to move the sub buttons when showing.
				null, // Ease type to scale the sub buttons when showing.
				null, // Ease type to rotate the sub buttons when showing.
				null, // Ease type to move the sub buttons when dismissing.
				null, // Ease type to scale the sub buttons when dismissing.
				null, // Ease type to rotate the sub buttons when dismissing.
				null // Rotation degree.
				);

		boomMenuButton.setTextViewColor(getResources().getColor(R.color.black));
	}
}
