/*
 * Copyright 2020 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.firebase.auth;

import com.google.firebase.auth.internal.GetAccountInfoRequest;
import com.google.firebase.internal.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Used for looking up an account by email.
 *
 * @see {FirebaseAuth#getUsers}
 */
public class EmailIdentifier extends UserIdentifier {
  private final String email;

  public EmailIdentifier(@NonNull String email) {
    UserRecord.checkEmail(email);
    this.email = email;
  }

  @Override
  public String toString() {
    return "EmailIdentifier(" + email + ")";
  }

  @Override
  void populate(@NonNull GetAccountInfoRequest payload) {
    payload.addEmail(email);
  }

  @Override
  boolean matches(@NonNull UserRecord userRecord) {
    return email.equals(userRecord.getEmail());
  }
}