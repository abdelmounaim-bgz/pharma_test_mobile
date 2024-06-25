package com.mascir.smartsensorfer.databinding;
import com.mascir.smartsensorfer.R;
import com.mascir.smartsensorfer.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentIsfetBindingImpl extends FragmentIsfetBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.IsfetProgress, 1);
        sViewsWithIds.put(R.id.IsfetLoadingText, 2);
        sViewsWithIds.put(R.id.IsfetScreen, 3);
        sViewsWithIds.put(R.id.guideline_start, 4);
        sViewsWithIds.put(R.id.guideline_end, 5);
        sViewsWithIds.put(R.id.guideline_top, 6);
        sViewsWithIds.put(R.id.guideline_bottom, 7);
        sViewsWithIds.put(R.id.showResults, 8);
        sViewsWithIds.put(R.id.IsfetCalibrate, 9);
        sViewsWithIds.put(R.id.IsfetMesure, 10);
        sViewsWithIds.put(R.id.IsfetValues, 11);
        sViewsWithIds.put(R.id.aVal, 12);
        sViewsWithIds.put(R.id.bVal, 13);
        sViewsWithIds.put(R.id.RCar, 14);
        sViewsWithIds.put(R.id.RcarVal, 15);
        sViewsWithIds.put(R.id.table_layout, 16);
        sViewsWithIds.put(R.id.numEchantIsfet, 17);
        sViewsWithIds.put(R.id.paramText, 18);
        sViewsWithIds.put(R.id.IsfetValue, 19);
        sViewsWithIds.put(R.id.IsfetUnit, 20);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentIsfetBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }
    private FragmentIsfetBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[9]
            , (android.widget.TextView) bindings[2]
            , (android.widget.Button) bindings[10]
            , (android.widget.ProgressBar) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[19]
            , (android.widget.LinearLayout) bindings[11]
            , (androidx.cardview.widget.CardView) bindings[14]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[13]
            , (androidx.constraintlayout.widget.Guideline) bindings[7]
            , (androidx.constraintlayout.widget.Guideline) bindings[5]
            , (androidx.constraintlayout.widget.Guideline) bindings[4]
            , (androidx.constraintlayout.widget.Guideline) bindings[6]
            , (android.widget.EditText) bindings[17]
            , (android.widget.TextView) bindings[18]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[8]
            , (android.widget.TableLayout) bindings[16]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}