#include <jni.h>
#include <string>

extern "C"
jstring
Java_com_duongnx_ndk_examples_activities_HelloJniActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
