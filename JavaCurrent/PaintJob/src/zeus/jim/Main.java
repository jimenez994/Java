package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int need = getBucketCount(3.4,1.5);
        System.out.println(need);
    }
    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets){
        if(width > 0 && height > 0 && areaPerBucket > 0 && extraBuckets >= 0){
            double totalArea = width*height;
            double bucketsRequire = totalArea/areaPerBucket;
            return (int) Math.ceil(bucketsRequire - extraBuckets);
        }else{
            return -1;
        }
    }
    public static int getBucketCount(double width, double height, double areaPerBucket){
        if(width > 0 && height > 0 && areaPerBucket > 0 ){
            double totalArea = width*height;
            double bucketsRequire = totalArea/areaPerBucket;
            return (int) Math.ceil(bucketsRequire);
        }else{
            return -1;
        }
    }
    public static int getBucketCount(double area, double areaPerBucket){
        if(area > 0 && areaPerBucket > 0 ){
            double bucketsRequire = area /areaPerBucket;
            return (int) Math.ceil(bucketsRequire);
        }else{
            return -1;
        }
    }
}
