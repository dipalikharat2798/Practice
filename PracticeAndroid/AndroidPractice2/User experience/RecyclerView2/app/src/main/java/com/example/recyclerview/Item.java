package com.example.recyclerview;

public class Item {

        private int imageId;
        private String hero;
        private String heroin;
        public Item(Integer imageId,String hero,String heroin){
            this.imageId=imageId;
            this.hero =hero;
            this.heroin=heroin;
        }
        public int getImageId(){return imageId;}
        public void setImageId(int imageId){
            this.imageId=imageId;
        }
        public  String getHero(){return hero;}
        public void setHero(String hero){
            this.hero=hero;
        }
        public String getHeroin(){return heroin;}
        public void setHeroin(String heroin){
            this.heroin=heroin;
        }

}
