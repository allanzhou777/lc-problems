class Solution {
    public String addBinary(String a, String b) {
        // use stringbuilder, append one character at a time, then reverse in the end
        StringBuilder sb = new StringBuilder();
        int i1 = a.length() - 1;
        int i2 = b.length() - 1;
        int carry = 0;
        while (i1 >= 0 || i2 >= 0) {

            int sum = carry;
            if (i1 >= 0) {
                sum += (a.charAt(i1) - '0');
                i1--;
            }
            if (i2 >= 0) {
                sum += (b.charAt(i2) - '0');
                i2--;
            }
            int digit = sum % 2;
            carry = sum / 2;
            sb.append(digit);
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
