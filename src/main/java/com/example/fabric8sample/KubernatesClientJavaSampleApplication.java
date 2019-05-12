package com.example.fabric8sample;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1PodList;
import io.kubernetes.client.util.Config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KubernatesClientJavaSampleApplication {
	public static void main(String[] args) {
		try {
			ApiClient client = Config.defaultClient();
			Configuration.setDefaultApiClient(client);

			CoreV1Api api = new CoreV1Api();
			V1PodList list = api.listPodForAllNamespaces(null, null, null, null, null, null);
			for (V1Pod item : list.getItems()) {
				System.out.println(item.getMetadata().getName());
			}
		} catch (Exception e){

		}

		//SpringApplication.run(Fabric8SampleApplication.class, args);
	}

}
