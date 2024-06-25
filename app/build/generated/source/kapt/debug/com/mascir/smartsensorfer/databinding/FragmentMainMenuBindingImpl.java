package com.mascir.smartsensorfer.databinding;
import com.mascir.smartsensorfer.R;
import com.mascir.smartsensorfer.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentMainMenuBindingImpl extends FragmentMainMenuBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.guideline_start, 1);
        sViewsWithIds.put(R.id.guideline_end, 2);
        sViewsWithIds.put(R.id.guideline_top, 3);
        sViewsWithIds.put(R.id.guideline_bottom, 4);
        sViewsWithIds.put(R.id.BtProgress, 5);
        sViewsWithIds.put(R.id.BtLoadingText, 6);
        sViewsWithIds.put(R.id.cnxBtn, 7);
        sViewsWithIds.put(R.id.anoucement, 8);
        sViewsWithIds.put(R.id.BtCnxBtn, 9);
        sViewsWithIds.put(R.id.Menu, 10);
        sViewsWithIds.put(R.id.poudre, 11);
        sViewsWithIds.put(R.id.comprime, 12);
        sViewsWithIds.put(R.id.liquid, 13);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentMainMenuBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private FragmentMainMenuBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton) bindings[9]
            , (android.widget.TextView) bindings[6]
            , (android.widget.ProgressBar) bindings[5]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.TextView) bindings[8]
            , (android.widget.LinearLayout) bindings[7]
            , (com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton) bindings[12]
            , (androidx.constraintlayout.widget.Guideline) bindings[4]
            , (androidx.constraintlayout.widget.Guideline) bindings[2]
            , (androidx.constraintlayout.widget.Guideline) bindings[1]
            , (androidx.constraintlayout.widget.Guideline) bindings[3]
            , (com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton) bindings[13]
            , (com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton) bindings[11]
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