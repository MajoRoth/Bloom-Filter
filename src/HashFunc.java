import java.util.Random;

public class HashFunc {

    private int _seed;
    private int _m;

    public HashFunc(int m){
        Random rand = new Random();
        _seed = rand.nextInt(Integer.MAX_VALUE); /* RANDOM THE SEED*/
        _m = m;
    }

    public int get_index_string(String text){
        /*
            get index bu element. 0 <= index < m
         */
        final byte[] bytes = text.getBytes();
        int hash = hash_32_bytes(bytes, bytes.length);
        return Math.abs(hash)%_m;
    }


    private int hash_32_bytes(final byte[] data, int length) {
        /*
            Implementation from github:
            https://github.com/tnm/murmurhash-java/blob/master/src/main/java/ie/ucd/murmur/MurmurHash.java
         */
        // 'm' and 'r' are mixing constants generated offline.
        // They're not really 'magic', they just happen to work well.
        final int m = 0x5bd1e995;
        final int r = 24;

        // Initialize the hash to a random value
        int h = _seed^length;
        int length4 = length/4;

        for (int i=0; i<length4; i++) {
            final int i4 = i*4;
            int k = (data[i4+0]&0xff) +((data[i4+1]&0xff)<<8)
                    +((data[i4+2]&0xff)<<16) +((data[i4+3]&0xff)<<24);
            k *= m;
            k ^= k >>> r;
            k *= m;
            h *= m;
            h ^= k;
        }

        // Handle the last few bytes of the input array
        switch (length%4) {
            case 3: h ^= (data[(length&~3) +2]&0xff) << 16;
            case 2: h ^= (data[(length&~3) +1]&0xff) << 8;
            case 1: h ^= (data[length&~3]&0xff);
                h *= m;
        }

        h ^= h >>> 13;
        h *= m;
        h ^= h >>> 15;

        return h;
    }
}
