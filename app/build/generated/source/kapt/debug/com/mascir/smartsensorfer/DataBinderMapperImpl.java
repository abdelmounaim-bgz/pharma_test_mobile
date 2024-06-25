package com.mascir.smartsensorfer;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.mascir.smartsensorfer.databinding.ActivityHomeBindingImpl;
import com.mascir.smartsensorfer.databinding.FragmentIsfetBindingImpl;
import com.mascir.smartsensorfer.databinding.FragmentMainMenuBindingImpl;
import com.mascir.smartsensorfer.databinding.FragmentScanBindingImpl;
import com.mascir.smartsensorfer.databinding.FragmentSpectroBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYHOME = 1;

  private static final int LAYOUT_FRAGMENTISFET = 2;

  private static final int LAYOUT_FRAGMENTMAINMENU = 3;

  private static final int LAYOUT_FRAGMENTSCAN = 4;

  private static final int LAYOUT_FRAGMENTSPECTRO = 5;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.mascir.smartsensorfer.R.layout.activity_home, LAYOUT_ACTIVITYHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.mascir.smartsensorfer.R.layout.fragment_isfet, LAYOUT_FRAGMENTISFET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.mascir.smartsensorfer.R.layout.fragment_main_menu, LAYOUT_FRAGMENTMAINMENU);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.mascir.smartsensorfer.R.layout.fragment_scan, LAYOUT_FRAGMENTSCAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.mascir.smartsensorfer.R.layout.fragment_spectro, LAYOUT_FRAGMENTSPECTRO);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYHOME: {
          if ("layout/activity_home_0".equals(tag)) {
            return new ActivityHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_home is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTISFET: {
          if ("layout/fragment_isfet_0".equals(tag)) {
            return new FragmentIsfetBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_isfet is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMAINMENU: {
          if ("layout/fragment_main_menu_0".equals(tag)) {
            return new FragmentMainMenuBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_main_menu is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSCAN: {
          if ("layout/fragment_scan_0".equals(tag)) {
            return new FragmentScanBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_scan is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSPECTRO: {
          if ("layout/fragment_spectro_0".equals(tag)) {
            return new FragmentSpectroBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_spectro is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/activity_home_0", com.mascir.smartsensorfer.R.layout.activity_home);
      sKeys.put("layout/fragment_isfet_0", com.mascir.smartsensorfer.R.layout.fragment_isfet);
      sKeys.put("layout/fragment_main_menu_0", com.mascir.smartsensorfer.R.layout.fragment_main_menu);
      sKeys.put("layout/fragment_scan_0", com.mascir.smartsensorfer.R.layout.fragment_scan);
      sKeys.put("layout/fragment_spectro_0", com.mascir.smartsensorfer.R.layout.fragment_spectro);
    }
  }
}
