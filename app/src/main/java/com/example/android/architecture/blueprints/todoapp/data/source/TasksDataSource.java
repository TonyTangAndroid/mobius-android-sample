/*
 * Copyright 2016, The Android Open Source Project
 * Copyright (c) 2017-2018 Spotify AB
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
package com.example.android.architecture.blueprints.todoapp.data.source;

import androidx.annotation.NonNull;
import com.example.android.architecture.blueprints.todoapp.data.Task;
import com.google.common.base.Optional;
import io.reactivex.Flowable;
import java.util.List;

/**
 * Main entry point for accessing allTasks data.
 *
 * <p>
 */
public interface TasksDataSource {

  Flowable<List<Task>> getTasks();

  Flowable<Optional<Task>> getTask(@NonNull String taskId);

  void saveTask(@NonNull Task task);

  void deleteAllTasks();

  void deleteTask(@NonNull String taskId);
}
