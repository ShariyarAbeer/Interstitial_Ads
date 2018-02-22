package www.adventsteel.com.ads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends AppCompatActivity {

    InterstitialAd interstitial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Prepare the Interstitial Ad
                interstitial = new InterstitialAd(MainActivity.this);
                // Insert the Ad Unit ID
                interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));
                interstitial.loadAd(new AdRequest.Builder().build());

                // Prepare an Interstitial Ad Listener
                interstitial.setAdListener(new AdListener() {
                    public void onAdLoaded() {
                        // Call displayInterstitial() function
                        displayInterstitial();
                    }
                });

            }
        });
    }
    public void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
}
