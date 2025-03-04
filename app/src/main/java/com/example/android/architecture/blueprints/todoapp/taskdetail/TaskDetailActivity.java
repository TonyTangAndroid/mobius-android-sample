/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.architecture.blueprints.todoapp.taskdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.data.Task;
import com.example.android.architecture.blueprints.todoapp.data.TaskBundlePacker;
import com.example.android.architecture.blueprints.todoapp.util.ActivityUtils;

/** Displays task details screen. */
public class TaskDetailActivity extends AppCompatActivity {

  public static final String EXTRA_TASK_ID = "TASK_ID";

  public static Intent showTask(Context c, Task task) {
    Intent i = new Intent(c, TaskDetailActivity.class);
    i.putExtra(EXTRA_TASK_ID, TaskBundlePacker.taskToBundle(task));
    return i;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.taskdetail_act);

    // Set up the toolbar.
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    ActionBar ab = getSupportActionBar();
    ab.setDisplayHomeAsUpEnabled(true);
    ab.setDisplayShowHomeEnabled(true);

    // Get the requested task id
    Task task = TaskBundlePacker.taskFromBundle(getIntent().getBundleExtra(EXTRA_TASK_ID));

    TaskDetailFragment taskDetailFragment =
        (TaskDetailFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

    if (taskDetailFragment == null) {
      taskDetailFragment = TaskDetailFragment.newInstance(task);

      ActivityUtils.addFragmentToActivity(
          getSupportFragmentManager(), taskDetailFragment, R.id.contentFrame);
    }
  }

  @Override
  public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }
}
