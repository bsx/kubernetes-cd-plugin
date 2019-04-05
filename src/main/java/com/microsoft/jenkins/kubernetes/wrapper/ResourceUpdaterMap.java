package com.microsoft.jenkins.kubernetes.wrapper;

import io.kubernetes.client.models.ExtensionsV1beta1Deployment;
import io.kubernetes.client.models.V1ConfigMap;
import io.kubernetes.client.models.V1DaemonSet;
import io.kubernetes.client.models.V1Deployment;
import io.kubernetes.client.models.V1Job;
import io.kubernetes.client.models.V1Namespace;
import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1ReplicaSet;
import io.kubernetes.client.models.V1ReplicationController;
import io.kubernetes.client.models.V1Secret;
import io.kubernetes.client.models.V1Service;
import io.kubernetes.client.models.V1StatefulSet;
import io.kubernetes.client.models.V1beta1CronJob;
import io.kubernetes.client.models.V1beta1DaemonSet;
import io.kubernetes.client.models.V1beta1Ingress;
import io.kubernetes.client.models.V1beta1ReplicaSet;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ResourceUpdaterMap extends HashMap<Class<?>, Class<? extends ResourceManager.ResourceUpdater>> {
    private static final Map<Class<?>, Class<? extends ResourceManager.ResourceUpdater>> INSTANCE =
            Collections.unmodifiableMap(new ResourceUpdaterMap());

    private ResourceUpdaterMap() {
        put(V1Namespace.class, V1ResourceManager.NamespaceUpdater.class);
        put(V1Deployment.class, V1ResourceManager.DeploymentUpdater.class);
        put(V1Service.class, V1ResourceManager.ServiceUpdater.class);
        put(V1ReplicationController.class, V1ResourceManager.ReplicationControllerUpdater.class);
        put(V1ReplicaSet.class, V1ResourceManager.ReplicaSetUpdater.class);
        put(V1DaemonSet.class, V1ResourceManager.DaemonSetUpdater.class);
        put(V1StatefulSet.class, V1ResourceManager.StatefulSetUpdater.class);
        put(V1Job.class, V1ResourceManager.JobUpdater.class);
        put(V1Pod.class, V1ResourceManager.PodUpdater.class);
        put(V1Secret.class, V1ResourceManager.SecretUpdater.class);
        put(V1ConfigMap.class, V1ResourceManager.ConfigMapUpdater.class);

        put(V1beta1Ingress.class, V1beta1ResourceManager.IngressUpdater.class);
        put(V1beta1DaemonSet.class, V1beta1ResourceManager.DaemonSetUpdater.class);
        put(V1beta1ReplicaSet.class, V1beta1ResourceManager.ReplicaSetUpdater.class);
        put(V1beta1CronJob.class, V1beta1ResourceManager.CronJobUpdater.class);

        put(ExtensionsV1beta1Deployment.class, ExtensionV1beta1ResourceManager.DeploymentUpdater.class);
    }

    public static Map<Class<?>, Class<? extends ResourceManager.ResourceUpdater>> getUnmodifiableInstance() {
        return INSTANCE;
    }
}
