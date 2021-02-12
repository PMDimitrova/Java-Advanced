package Telephony;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

//    private List<String> clearUrls(List<String> urls) {
//        List<String> output = new ArrayList<>();
//        for (String url : this.urls) {
//            boolean containsDigit = false;
//            for (int i = 0; i < url.length(); i++) {
//                if (Character.isDigit(url.charAt(i))) {
//                    urls.remove(url);
//                    containsDigit = true;
//                    break;
//                }
//            }
//            if (!containsDigit){
//                output.add(url);
//            }
//        }
//        return output;
//    }

    @Override
    public String browse() {
        String output = "";
        for (String url : this.urls) {
            boolean containsDigit = false;
            for (int i = 0; i < url.length(); i++) {
                if (Character.isDigit(url.charAt(i))) {
                    containsDigit = true;
                }
            }
            if (!containsDigit) {
                output += "Browsing... " + url + "!" + System.lineSeparator();
            }else{
                output += "Invalid URL!" + System.lineSeparator();
            }
        }
        return output;
    }

    @Override
    public String call() {
        String output = "";
        for (String num : this.numbers) {
            output += "Calling... " + num + System.lineSeparator();
        }
        return output;
    }
}
