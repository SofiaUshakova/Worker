public class Worker {

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    private OnTaskDoneListener callback;

    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String error);
    }

    private OnTaskErrorListener errorCallback = error -> {
        error = "Task 33 failed";
        System.out.println(error);
    };

    public void Error(OnTaskErrorListener errorCallback) {
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallback.onError("Task " + i + " failed");
            } else {
                callback.onDone("Task " + i + " is done");
            }
        }
    }
}





