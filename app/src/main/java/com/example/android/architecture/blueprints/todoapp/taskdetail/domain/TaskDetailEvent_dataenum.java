/*
 * -\-\-
 * --
 * Copyright (c) 2017-2018 Spotify AB
 * --
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
 * -/-/-
 */
package com.example.android.architecture.blueprints.todoapp.taskdetail.domain;

import com.spotify.dataenum.DataEnum;
import com.spotify.dataenum.dataenum_case;

@DataEnum
interface TaskDetailEvent_dataenum {
  dataenum_case DeleteTaskRequested();

  dataenum_case CompleteTaskRequested();

  dataenum_case ActivateTaskRequested();

  dataenum_case EditTaskRequested();

  dataenum_case TaskDeleted();

  dataenum_case TaskMarkedComplete();

  dataenum_case TaskMarkedActive();

  dataenum_case TaskSaveFailed();

  dataenum_case TaskDeletionFailed();
}
