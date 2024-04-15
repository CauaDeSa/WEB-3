package br.edu.ifsp.arqweb1.ifitness.model.util.activities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.edu.ifsp.arqweb1.ifitness.model.Activity;
import br.edu.ifsp.arqweb1.ifitness.model.util.users.LocalDateTypeAdapter;

public final class ActivityReader {

	public static final String PATH = "C:\\Users\\cauar\\Documents\\Nova pasta\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\7. iFitness\\data\\activities.json";

	private ActivityReader() {}

	public static List<Activity> read() {
		List<Activity> activities = null;
		Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();

		try (var buffer = new BufferedReader(new FileReader(PATH))) {

			TypeToken<List<Activity>> type = new TypeToken<List<Activity>>() {};
			activities = gson.fromJson(buffer, type);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return activities;
	}
}