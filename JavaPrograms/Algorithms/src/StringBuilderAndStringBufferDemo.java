public class StringBuilderAndStringBufferDemo {
 
    public static void main(String[] args) throws InterruptedException {
      int n = 10;
    
      StringBuilder text = new StringBuilder();
      StringBuilderScaler builderThread = new StringBuilderScaler(text);
      StringBuilderScaler builderThread2 = new StringBuilderScaler(text);
      StringBuilderScaler builderThread3 = new StringBuilderScaler(text);
      builderThread.start();
      builderThread2.start();
      builderThread3.start();
      builderThread.join();
      builderThread2.join();
      builderThread3.join();
      System.out.println("StringBuilder:" + text.toString());
    
    
      StringBuffer text2 = new StringBuffer();
      StringBufferScaler bufferThread = new StringBufferScaler(text2);
      StringBufferScaler bufferThread2 = new StringBufferScaler(text2);
      StringBufferScaler bufferThread3 = new StringBufferScaler(text2);
      bufferThread.start();
      bufferThread2.start();
      bufferThread3.start();
      bufferThread.join();
      bufferThread2.join();
      bufferThread3.join();
      System.out.println("StringBuffer:" + text2.toString());
    
    }
    
   }
   class StringBuilderScaler extends Thread {
    StringBuilder text;
    
    public StringBuilderScaler (StringBuilder sb) {
      text = sb;
    }
    
    @Override
    public void run() {
      for (int i = 0; i < 10; i++) {
        text.append(i);
      }
    }
   }
    
    
   class StringBufferScaler extends Thread {
    StringBuffer text;
    
    public StringBufferScaler (StringBuffer sb) {
      text = sb;
    }
    @Override
    public void run() {
      for (int i = 0; i < 10; i++) {
        text.append(i);
      }
    }
   }
   