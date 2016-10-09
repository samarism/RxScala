/**
 * Copyright 2015 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rx.lang.scala.completeness

import scala.reflect.runtime.universe.typeOf

class TestSchedulerCompletenessKit extends CompletenessKit {
  override val rxJavaType = typeOf[rx.schedulers.TestScheduler]

  override val rxScalaType = typeOf[rx.lang.scala.schedulers.TestScheduler]

  // There are two methods without "()", so using `isOmittingParenthesesForArity0Method = true` by default is simpler
  override protected def correspondenceChanges: Map[String, String] = Map(
    "triggerActions()" -> "triggerActions()",
    "when(Func1[Observable[Observable[Completable]], Completable])" -> "[TODO]"
  )
}