package br.edu.ifsp.arqweb1.ifitness.model.util.activities;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.edu.ifsp.arqweb1.ifitness.model.Activity;
import br.edu.ifsp.arqweb1.ifitness.model.util.users.LocalDateTypeAdapter;

public final class ActivityWriter {

	private ActivityWriter() {

	}

	public static final Boolean write(Activity activity) {
		List<Activity> activities = ActivityReader.read();
		Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
		String path = ActivityReader.PATH;

		if (activities == null) {
			activities = new ArrayList<Activity>();
			activity.setId(1L);
		} else {
			activity.setId(activities.get(activities.size() - 1).getId() + 1L);
		}

		activities.add(activity);
		
		String json = gson.toJson(activities);
		
		try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(json);
            fileWriter.close();
		} catch (IOException e) {
            e.printStackTrace();
        }
		
		return true;
		
	}
}