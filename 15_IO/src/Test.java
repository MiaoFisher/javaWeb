public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("方法执行....");
        //这里用于提升客户体验
        //这里是项目经理要求，客户给钱就删掉这行代码
        Thread.sleep(3000);
        System.out.println("方法执行完成....");
    }
}
