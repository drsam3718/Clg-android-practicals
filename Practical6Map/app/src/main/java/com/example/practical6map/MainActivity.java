package com.example.practical6map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 8, 0},
        d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"},
        d2 = {"Lcom/example/prectical6mapsusingkotlin/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "()V", "destinationLatitude", "", "destinationLongitude", "mMap", "Lcom/google/android/gms/maps/GoogleMap;", "originLatitude", "originLongitude", "decodePolyline", "", "Lcom/google/android/gms/maps/model/LatLng;", "encoded", "", "getDirectionURL", "origin", "dest", "secret", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onMapReady", "p0", "GetDirection", "app_debug"}
)
public final class MainActivity extends AppCompatActivity {
    private GoogleMap mMap;
    private final double originLatitude = 28.5021359;
    private final double originLongitude = 77.4054901;
    private final double destinationLatitude = 28.5151087;
    private final double destinationLongitude = 77.3932163;

    @SuppressLint("ResourceType")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.setContentView(1300000);
//        Context var10000 = this.getApplicationContext();
//        Intrinsics.checkNotNullExpressionValue(var10000, "applicationContext");
//        PackageManager var7 = var10000.getPackageManager();
//        Context var10001 = this.getApplicationContext();
//        Intrinsics.checkNotNullExpressionValue(var10001, "applicationContext");
//        ApplicationInfo var8;
//        try {
//            var8 = var7.getApplicationInfo(var10001.getPackageName(), 128);
//        } catch (PackageManager.NameNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        Intrinsics.checkNotNullExpressionValue(var8, "applicationContext.packageManager.GET_META_DATA)");
//        ApplicationInfo ai = var8;
//        Object value = ai.metaData.get("com.google.android.geo.API_KEY");
//        final String apiKey = String.valueOf(value);
//        if (!Places.isInitialized()) {
//            Places.initialize(this.getApplicationContext(), apiKey);
//        }
//
//        Fragment var9 = this.getSupportFragmentManager().findFragmentById(1000001);
//        if (var9 == null) {
//            throw new NullPointerException("null cannot be cast to non-null type com.google.android.gms.maps.SupportMapFragment");
//        } else {
//            final SupportMapFragment mapFragment = (SupportMapFragment) var9;
//            mapFragment.getMapAsync((OnMapReadyCallback) this);
//            Button gd = (Button) this.findViewById(1000000);
//            gd.setOnClickListener((View.OnClickListener) (it -> mapFragment.getMapAsync((OnMapReadyCallback) (it1 -> {
//                MainActivity var100001 = MainActivity.this;
//                Intrinsics.checkNotNullExpressionValue(it1, "it");
//                var100001.mMap = it1;
//                LatLng originLocation = new LatLng(MainActivity.this.originLatitude, MainActivity.this.originLongitude);
//                MainActivity.access$getMMap$p(MainActivity.this).addMarker((new MarkerOptions()).position(originLocation));
//                LatLng destinationLocation = new LatLng(MainActivity.this.destinationLatitude, MainActivity.this.destinationLongitude);
//                MainActivity.access$getMMap$p(MainActivity.this).addMarker((new MarkerOptions()).position(destinationLocation));
//                MainActivity.access$getMMap$p(MainActivity.this).animateCamera(CameraUpdateFactory.newLatLngZoom(originLocation, 14.0F));
//            }))));
//        }
    }

//    public void onMapReady(@Nullable GoogleMap p0) {
//        Intrinsics.checkNotNull(p0);
//        this.mMap = p0;
//        LatLng originLocation = new LatLng(this.originLatitude, this.originLongitude);
//        GoogleMap var10000 = this.mMap;
//        if (var10000 == null) {
//            Intrinsics.throwUninitializedPropertyAccessException("mMap");
//        }
//
//        var10000.clear();
//        var10000 = this.mMap;
//        if (var10000 == null) {
//            Intrinsics.throwUninitializedPropertyAccessException("mMap");
//        }
//
//        var10000.addMarker((new MarkerOptions()).position(originLocation));
//        var10000 = this.mMap;
//        if (var10000 == null) {
//            Intrinsics.throwUninitializedPropertyAccessException("mMap");
//        }
//
//        var10000.animateCamera(CameraUpdateFactory.newLatLngZoom(originLocation, 18.0F));
//    }

    // $FF: synthetic method
//    public static GoogleMap access$getMMap$p(MainActivity $this) {
//        GoogleMap var10000 = $this.mMap;
//        if (var10000 == null) {
//            Intrinsics.throwUninitializedPropertyAccessException("mMap");
//        }
//
//        return var10000;
//    }

}