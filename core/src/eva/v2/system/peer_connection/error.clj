;; Copyright 2015-2019 Workiva Inc.
;; 
;; Licensed under the Eclipse Public License 1.0 (the "License");
;; you may not use this file except in compliance with the License.
;; You may obtain a copy of the License at
;; 
;;      http://opensource.org/licenses/eclipse-1.0.php
;; 
;; Unless required by applicable law or agreed to in writing, software
;; distributed under the License is distributed on an "AS IS" BASIS,
;; WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
;; See the License for the specific language governing permissions and
;; limitations under the License.

(ns eva.v2.system.peer-connection.error
  (:require [eva.error :refer [deferror-group]]))

(deferror-group timeout
  (:peer-timeout [:timeout-ms])
  (transact "Peer timed out" [:tx-data-size]))

(deferror-group connect-failure
  (:peer-connect [:peer-id :database-id])
  (message-queue "Unable to connect to message queue")
  (resource-manager "Unable to acquire a resource")
  (unrecognized-cause "Unable to acquire a peer connection"))
