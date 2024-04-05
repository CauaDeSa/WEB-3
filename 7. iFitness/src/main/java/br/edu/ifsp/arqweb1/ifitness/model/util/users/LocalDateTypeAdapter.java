package br.edu.ifsp.arqweb1.ifitness.model.util.users;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class LocalDateTypeAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate>{
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");

	@Override
	public JsonElement serialize(LocalDate date, Type type, JsonSerializationContext context){
		return new JsonPrimitive(date.format(formatter));
	}

	@Override
	public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context)
			throws JsonParseException {
		return LocalDate.parse(json.getAsString(), formatter);
	}

}