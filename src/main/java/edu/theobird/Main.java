package edu.theobird;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static JLabel platebox = new JLabel("");

    public static String generate() {
        Random rand = new Random();

        String codesJSON = "{\"AB\":\"AB\",\"AC\":\"AC\",\"AE\":\"AE\",\"AF\":\"AF\",\"AG\":\"AG\",\"AH\":\"AH\",\"AJ\":\"AJ\",\"AK\":\"AK\",\"AL\":\"AL\",\"AM\":\"AM\",\"AN\":\"AN\",\"AO\":\"AO\",\"AP\":\"AP\",\"AR\":\"AR\",\"AS\":\"AS\",\"AT\":\"AT\",\"AU\":\"AU\",\"AV\":\"AV\",\"AW\":\"AW\",\"AX\":\"AX\",\"AY\":\"AY\",\"BA\":\"BA\",\"BB\":\"BB\",\"BC\":\"BC\",\"BD\":\"BD\",\"BE\":\"BE\",\"BF\":\"BF\",\"BG\":\"BG\",\"BH\":\"BH\",\"BJ\":\"BJ\",\"BK\":\"BK\",\"BL\":\"BL\",\"BM\":\"BM\",\"BN\":\"BN\",\"BO\":\"BO\",\"BP\":\"BP\",\"BR\":\"BR\",\"BS\":\"BS\",\"BT\":\"BT\",\"BU\":\"BU\",\"BV\":\"BV\",\"BW\":\"BW\",\"BX\":\"BX\",\"BY\":\"BY\",\"CA\":\"CA\",\"CB\":\"CB\",\"CC\":\"CC\",\"CD\":\"CD\",\"CE\":\"CE\",\"CF\":\"CF\",\"CG\":\"CG\",\"CH\":\"CH\",\"CJ\":\"CJ\",\"CK\":\"CK\",\"CL\":\"CL\",\"CM\":\"CM\",\"CN\":\"CN\",\"CO\":\"CO\",\"CP\":\"CP\",\"CR\":\"CR\",\"CS\":\"CS\",\"CT\":\"CT\",\"CU\":\"CU\",\"CV\":\"CV\",\"CW\":\"CW\",\"CX\":\"CX\",\"CY\":\"CY\",\"DA\":\"DA\",\"DB\":\"DB\",\"DC\":\"DC\",\"DD\":\"DD\",\"DE\":\"DE\",\"DF\":\"DF\",\"DG\":\"DG\",\"DH\":\"DH\",\"DJ\":\"DJ\",\"DK\":\"DK\",\"DL\":\"DL\",\"DM\":\"DM\",\"DN\":\"DN\",\"DO\":\"DO\",\"DP\":\"DP\",\"DR\":\"DR\",\"DS\":\"DS\",\"DT\":\"DT\",\"DU\":\"DU\",\"DV\":\"DV\",\"DW\":\"DW\",\"DX\":\"DX\",\"DY\":\"DY\",\"EA\":\"EA\",\"EB\":\"EB\",\"EC\":\"EC\",\"ED\":\"ED\",\"EE\":\"EE\",\"EF\":\"EF\",\"EG\":\"EG\",\"EH\":\"EH\",\"EJ\":\"EJ\",\"EK\":\"EK\",\"EL\":\"EL\",\"EM\":\"EM\",\"EN\":\"EN\",\"EO\":\"EO\",\"EP\":\"EP\",\"ER\":\"ER\",\"ES\":\"ES\",\"ET\":\"ET\",\"EU\":\"EU\",\"EV\":\"EV\",\"EW\":\"EW\",\"EX\":\"EX\",\"EY\":\"EY\",\"FA\":\"FA\",\"FB\":\"FB\",\"FC\":\"FC\",\"FD\":\"FD\",\"FE\":\"FE\",\"FF\":\"FF\",\"FG\":\"FG\",\"FH\":\"FH\",\"FJ\":\"FJ\",\"FK\":\"FK\",\"FL\":\"FL\",\"FM\":\"FM\",\"FN\":\"FN\",\"FO\":\"FO\",\"FP\":\"FP\",\"FR\":\"FR\",\"FS\":\"FS\",\"FT\":\"FT\",\"FU\":\"FU\",\"FV\":\"FV\",\"FW\":\"FW\",\"FX\":\"FX\",\"FY\":\"FY\",\"GA\":\"GA\",\"GB\":\"GB\",\"GC\":\"GC\",\"GD\":\"GD\",\"GE\":\"GE\",\"GF\":\"GF\",\"GG\":\"GG\",\"GH\":\"GH\",\"GJ\":\"GJ\",\"GK\":\"GK\",\"GL\":\"GL\",\"GM\":\"GM\",\"GN\":\"GN\",\"GO\":\"GO\",\"GP\":\"GP\",\"GR\":\"GR\",\"GS\":\"GS\",\"GT\":\"GT\",\"GU\":\"GU\",\"GV\":\"GV\",\"GW\":\"GW\",\"GX\":\"GX\",\"GY\":\"GY\",\"HA\":\"HA\",\"HB\":\"HB\",\"HC\":\"HC\",\"HD\":\"HD\",\"HE\":\"HE\",\"HF\":\"HF\",\"HG\":\"HG\",\"HH\":\"HH\",\"HJ\":\"HJ\",\"HK\":\"HK\",\"HL\":\"HL\",\"HM\":\"HM\",\"HN\":\"HN\",\"HO\":\"HO\",\"HP\":\"HP\",\"HR\":\"HR\",\"HS\":\"HS\",\"HT\":\"HT\",\"HU\":\"HU\",\"HV\":\"HV\",\"HW\":\"HW\",\"HX\":\"HX\",\"HY\":\"HY\"}";

        int year = rand.nextInt(9)+1;

        if (rand.nextInt(2) == 1) {
            year += (rand.nextInt(3)*10)+50;
        }
        DecimalFormat df = new DecimalFormat("00");
        String yearformatted = df.format(year);

        String code = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            HashMap<String, String> map = objectMapper.readValue(codesJSON, new TypeReference<HashMap<String, String>>() {});


            code = (String) map.get(randomkey(Collections.unmodifiableMap(map)));

        } catch (IOException e) {
            e.printStackTrace();
        }

        //the three last letters
        String allowedLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".replace("I", "").replace("Q", "").replace("O", "");
        StringBuilder randletters = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int index = rand.nextInt(allowedLetters.length());
            randletters.append(allowedLetters.charAt(index));
        }

        return code+yearformatted+" "+randletters;
    }

    public static String randomkey(Map<String, String> map){
        Random rand = new Random();
        Object[] keys = map.keySet().toArray();
        return keys[rand.nextInt(keys.length)].toString();
    }

    public static void main(String[] args) {

        Interface frame = new Interface();
    }
}