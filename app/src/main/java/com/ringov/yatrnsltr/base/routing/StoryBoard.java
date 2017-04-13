package com.ringov.yatrnsltr.base.routing;

import android.content.Intent;
import android.net.Uri;

/**
 * Created by Sergey Koltsov on 14.04.2017.
 */

public class StoryBoard {
    public static StoryDestination yandexTranslateLink(){
        return context -> {
            String url = "https://www.translate.yandex.ru";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            context.startActivity(i);
        };
    }
}