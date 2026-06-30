# LeetCode Problem 831: Masking Personal Information

## Problem Statement
You are given a string `S` representing either an email address or a phone number.  
Your task is to mask the personal information following these rules:

- **Email:**
  - Convert all letters to lowercase.
  - Keep the first and last character of the name before the `@`.
  - Replace the middle characters with 5 asterisks (`*`).
  - Example: `"LeetCode@LeetCode.com"` → `"l*****e@leetcode.com"`

- **Phone Number:**
  - Remove all non-digit characters.
  - The last 10 digits represent the local number.
  - Mask the local number as `"***-***-XXXX"`.
  - If there are country code digits, mask them as `"+"` followed by asterisks and a dash.
  - Example: `"86-(10)12345678"` → `"+**-***-***-5678"`

---

## My Solution (Java)

```java
class Solution {
    public String maskPII(String S) {
        String[] ctry = {"","+*-","+**-","+***-"};
        int at = S.indexOf("@");
        if(at > 0){
            S = S.toLowerCase();
            return (S.charAt(0) + "*****" + S.substring(at-1).toLowerCase());
        }
        S = S.replaceAll("[^0-9]","");
        return ctry[S.length()-10] + "***-***-" + S.substring(S.length()-4);
    }
}
```

---

## Explanation
- If the input contains `"@"`, it is treated as an **email**:
  - Convert to lowercase.
  - Keep the first and last character of the local name.
  - Replace the middle with `"*****"`.
- Otherwise, treat it as a **phone number**:
  - Remove all non-digit characters.
  - Determine the country code length (`S.length() - 10`).
  - Format as `"+***-***-***-XXXX"` depending on country code length.
  - Append the last 4 digits of the number.

---

## Sample Input/Output

### Example 1
**Input:**  
`S = "LeetCode@LeetCode.com"`  

**Output:**  
`"l*****e@leetcode.com"`  

### Example 2
**Input:**  
`S = "86-(10)12345678"`  

**Output:**  
`"+**-***-***-5678"`  

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each character is processed once.
- **Space Complexity:** `O(n)`  
  StringBuilder and substring operations use linear space.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
