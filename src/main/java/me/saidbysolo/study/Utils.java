package me.saidbysolo.study;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Utils {
    private final Study plugin;
    private static final JSONParser parser = new JSONParser();
    private static final Random random = new Random();

    public Utils(Study plugin) {
        this.plugin = plugin;
    }

    // O X 구간 저장
    public void setConfig(Location firstLocation, Location secondLocation, Boolean correct) {
        if (correct) {
            this.plugin.config.set("correctLocation.firstLocation.X", firstLocation.getX());
            this.plugin.config.set("correctLocation.firstLocation.Y", firstLocation.getY());
            this.plugin.config.set("correctLocation.firstLocation.Z", firstLocation.getZ());
            this.plugin.config.set("correctLocation.secondLocation.X", secondLocation.getX());
            this.plugin.config.set("correctLocation.secondLocation.Y", secondLocation.getY());
            this.plugin.config.set("correctLocation.secondLocation.Z", secondLocation.getZ());
        } else {
            this.plugin.config.set("negativeLocation.firstLocation.X", firstLocation.getX());
            this.plugin.config.set("negativeLocation.firstLocation.Y", firstLocation.getY());
            this.plugin.config.set("negativeLocation.firstLocation.Z", firstLocation.getZ());
            this.plugin.config.set("negativeLocation.secondLocation.X", secondLocation.getX());
            this.plugin.config.set("negativeLocation.secondLocation.Y", secondLocation.getY());
            this.plugin.config.set("negativeLocation.secondLocation.Z", secondLocation.getZ());
        }
    }

    // JSON 로드 하는 메소드 이거 나중에 셔플로 하던지 아니면 어레이에 넣고하면 될듯
    public JSONObject loadJSON() {
        try {
            Object obj = parser.parse(new FileReader("/home/opc/asdf.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray dataArray = (JSONArray) jsonObject.get("data");
            JSONObject randomResult = (JSONObject) dataArray.get(random.nextInt(dataArray.toArray().length));
            return randomResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    // 메세지 보내기
    public void allSendMessage(ArrayList<UUID> playerUUIDList, String msg) {
        for (UUID playerUUID : playerUUIDList) {
            Bukkit.getPlayer(playerUUID).sendMessage(msg);
        }

    }

}
