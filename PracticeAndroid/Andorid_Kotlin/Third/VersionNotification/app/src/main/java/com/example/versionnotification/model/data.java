package com.example.versionnotification.model;

public class data {
    String CurrentReleaseDate;
    String VersionSummary;
    int CurrentVersion;
    int PreviousVersion;
    public data(){}
    public data(String currentReleaseDate, String versionSummary, int currentVersion, int previousVersion) {
        CurrentReleaseDate = currentReleaseDate;
        VersionSummary = versionSummary;
        CurrentVersion = currentVersion;
        PreviousVersion = previousVersion;
    }

    public String getCurrentReleaseDate() {
        return CurrentReleaseDate;
    }

    public void setCurrentReleaseDate(String currentReleaseDate) {
        CurrentReleaseDate = currentReleaseDate;
    }

    public String getVersionSummary() {
        return VersionSummary;
    }

    public void setVersionSummary(String versionSummary) {
        VersionSummary = versionSummary;
    }

    public int getCurrentVersion() {
        return CurrentVersion;
    }

    public void setCurrentVersion(int currentVersion) {
        CurrentVersion = currentVersion;
    }

    public int getPreviousVersion() {
        return PreviousVersion;
    }

    public void setPreviousVersion(int previousVersion) {
        PreviousVersion = previousVersion;
    }
}
