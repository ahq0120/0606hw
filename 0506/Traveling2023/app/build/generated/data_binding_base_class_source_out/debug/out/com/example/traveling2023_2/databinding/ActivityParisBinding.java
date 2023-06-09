// Generated by view binder compiler. Do not edit!
package com.example.traveling2023_2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.traveling2023_2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityParisBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final FloatingActionButton likeFab;

  @NonNull
  public final TextView likeText;

  @NonNull
  public final TextView parisDesp;

  @NonNull
  public final TextView parisOptText;

  private ActivityParisBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView imageView,
      @NonNull FloatingActionButton likeFab, @NonNull TextView likeText,
      @NonNull TextView parisDesp, @NonNull TextView parisOptText) {
    this.rootView = rootView;
    this.imageView = imageView;
    this.likeFab = likeFab;
    this.likeText = likeText;
    this.parisDesp = parisDesp;
    this.parisOptText = parisOptText;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityParisBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityParisBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_paris, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityParisBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.likeFab;
      FloatingActionButton likeFab = ViewBindings.findChildViewById(rootView, id);
      if (likeFab == null) {
        break missingId;
      }

      id = R.id.likeText;
      TextView likeText = ViewBindings.findChildViewById(rootView, id);
      if (likeText == null) {
        break missingId;
      }

      id = R.id.parisDesp;
      TextView parisDesp = ViewBindings.findChildViewById(rootView, id);
      if (parisDesp == null) {
        break missingId;
      }

      id = R.id.parisOptText;
      TextView parisOptText = ViewBindings.findChildViewById(rootView, id);
      if (parisOptText == null) {
        break missingId;
      }

      return new ActivityParisBinding((ConstraintLayout) rootView, imageView, likeFab, likeText,
          parisDesp, parisOptText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
