/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.jenkins.kubernetes.wrapper;

import io.kubernetes.client.models.V1beta1CronJob;
import io.kubernetes.client.models.V1beta1DaemonSet;
import io.kubernetes.client.models.V1beta1Ingress;
import io.kubernetes.client.models.V1beta1ReplicaSet;

public interface V1beta1ResourceUpdateMonitor {

    void onIngressUpdate(V1beta1Ingress original, V1beta1Ingress current);

    void onDaemonSetUpdate(V1beta1DaemonSet original, V1beta1DaemonSet current);

    void onReplicaSetUpdate(V1beta1ReplicaSet original, V1beta1ReplicaSet current);

    void onCronJobUpdate(V1beta1CronJob original, V1beta1CronJob current);

    V1beta1ResourceUpdateMonitor NOOP = new Adapter();

    class Adapter implements V1beta1ResourceUpdateMonitor {
        @Override
        public void onIngressUpdate(V1beta1Ingress original, V1beta1Ingress current) {
        }

        @Override
        public void onDaemonSetUpdate(V1beta1DaemonSet original, V1beta1DaemonSet current) {
        }

        @Override
        public void onReplicaSetUpdate(V1beta1ReplicaSet original, V1beta1ReplicaSet current) {
        }

        @Override
        public void onCronJobUpdate(V1beta1CronJob original, V1beta1CronJob current) {
        }
    }
}
