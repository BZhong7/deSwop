package com.bzhong7.labs.dswopapp.Main;


/**
 * DatingApp
 * https://github.com/quintuslabs/DatingApp
 * Created on 25-sept-2018.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */

public class Cards {
    private String userId;
    private String name, profileImageUrl, description, category;
    private int distance;

    public Cards(String userId, String name, String profileImageUrl, String description, String category, int distance) {
        this.userId = userId;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.description = description;
        this.category = category;
        this.distance = distance;
    }

    public Cards(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public int getDistance() {
        return distance;
    }

    public String getDescription() {
        return description;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
