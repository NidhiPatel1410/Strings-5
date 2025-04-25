// In this problem we have been given that, there a file which stores characters, and this file is not directly accessible to us. We
// can only read file using read4 method, which when called gets the 4 characters from file and stores in buf4 char array and return
// the integer value of the number of chars read. So, at once it will always read 4 chars, and return 4, but if suppose there are 
// only 3 chars in the file, it will return 3. We have to implement read method, such that we will pass the empty char buf[] array to
// it and also n. So we have to read n chars and store it in buf and return how much chars read. We are taking our own char array
// mybuffer and its size in bufsize and index on it. We will initially make the first read when the bufsize is 0. Then we will also
// take index on the resultant buf array which is going to store n chars. So we start looping till i<n and bufsize > 0. We copy the
// first char in myBuffer to the buf array. Then increment both i and index. Supoose in between if index becomes equal to the size 
// of mybuffer, we call read4 again to read next 4 chars. And reset index to 0. Then return i at last.

// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class ReadNCharsGivenRead4 {
    char[] myBuffer=new char[4];
    int bufsize;
    int index;
    public int read(char[] buf, int n){
        // Base when bufsize is 0, call read4 and store chars in myBuffer
        if(bufsize==0){
            bufsize=read4(myBuffer);
        }
        // i for number of chars that were read and stored
        int i=0;
        // Loop
        while(i<n && bufsize>0){
            // Copy char one by one
            buf[i++]=myBuffer[index++];
            // If we are at the last char in myBuffer, call read4 again to read next 4 chars
            if(index==bufsize){
                bufsize=read4(myBuffer);
                // Reset index on it to 0
                index=0;
            }
        }
    }
    // Return i
    return i;
}
