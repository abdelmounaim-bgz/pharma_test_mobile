package com.mascir.smartsensorfer.databinding;
import com.mascir.smartsensorfer.R;
import com.mascir.smartsensorfer.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentScanBindingImpl extends FragmentScanBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.guideline_start, 1);
        sViewsWithIds.put(R.id.guideline_end, 2);
        sViewsWithIds.put(R.id.resView, 3);
        sViewsWithIds.put(R.id.resImg, 4);
        sViewsWithIds.put(R.id.resText, 5);
        sViewsWithIds.put(R.id.resBtn, 6);
        sViewsWithIds.put(R.id.scan_progress, 7);
        sViewsWithIds.put(R.id.scan_loading_text, 8);
        sViewsWithIds.put(R.id.insertion, 9);
        sViewsWithIds.put(R.id.cal_btn, 10);
        sViewsWithIds.put(R.id.name, 11);
        sViewsWithIds.put(R.id.scan_btn, 12);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentScanBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private FragmentScanBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[10]
            , (androidx.constraintlayout.widget.Guideline) bindings[2]
            , (androidx.constraintlayout.widget.Guideline) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[9]
            , (android.widget.EditText) bindings[11]
            , (android.widget.Button) bindings[6]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.Button) bindings[12]
            , (android.widget.TextView) bindings[8]
            , (android.widget.ProgressBar) bindings[7]
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