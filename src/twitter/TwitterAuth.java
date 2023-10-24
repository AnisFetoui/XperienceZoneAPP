/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

import twitter4j.auth.Authorization;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAuth {
    private static final String CONSUMER_KEY = "S8y0H1RPWBGL4i7sK8Bt4t6PE";
    private static final String CONSUMER_SECRET = "2qtbQIhrcpPZfTSbtmEZqTAgatgvrqLfL5zNTIJc1c5DsAKvqs";
    private static final String ACCESS_TOKEN = "1716559835519737856-222mTsMOXyrqF8VDE5fqeAMm2CDxz8";
    private static final String ACCESS_TOKEN_SECRET = "CRDrNGB7qpIO3YuFLMoVeVK27yH45aBO4qPoO26bjVSpc";

    public static Authorization getAuthorization() {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setOAuthConsumerKey(CONSUMER_KEY)
               .setOAuthConsumerSecret(CONSUMER_SECRET)
               .setOAuthAccessToken(ACCESS_TOKEN)
               .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
        Configuration configuration = builder.build();
        return new OAuthAuthorization(configuration);
    }
}