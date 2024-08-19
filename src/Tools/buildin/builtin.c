#define bool _Bool

int printf(const char *pattern, ...);

int scanf(const char *__restrict format, ...);

int sprintf(char *str, const char *pattern, ...);

int strlen(const char *str);

int sscanf(const char *__restrict s, const char *__restrict format, ...);

int strcmp(const char *s1, const char *s2);

char* strcat(char *__restrict dest, const char *__restrict src);

void* malloc(unsigned int size);

void print(char *str) {
  printf("%s", str);
}

void println(char *str) {
  printf("%s\n", str);
}

void printInt(int num) {
  printf("%d", num);
}

void printlnInt(int num) {
  printf("%d\n", num);
}

char* getString() {
  char *str = (char*) malloc(1024 * sizeof(char));
  scanf("%s", str);
  return str;
}

int getInt() {
  int num;
  scanf("%d", &num);
  return num;
}

char* toString(int i) {
  char *str = (char*) malloc(12 * sizeof(char));
  sprintf(str, "%d", i);
  return str;
}

char* booltoString(bool c) {
  char *str;
  if (c) {
    sprintf(str, "true");
  } else {
    sprintf(str, "false");
  }
  return str;
}

int string_length(char *str) {
  return strlen(str);
}

char* string_substring(char *str, int left, int right) {
  char *sub = (char*) malloc((right - left + 2) * sizeof(char));
  int len = right - left + 1;
  for (int i = 0; i < len; i++) {
    sub[i] = str[left + i];
  }
  sub[len] = '\0';
  return sub;
}

int string_parseInt(char *str) {
  int num;
  sscanf(str, "%d", &num);
  return num;
}

int string_ord(char *str, int pos) {
  return str[pos];
}

bool string_lt(char *str1, char *str2) {
  return strcmp(str1, str2) < 0;
}

bool string_le(char *str1, char *str2) {
  return strcmp(str1, str2) <= 0;
}

bool string_gt(char *str1, char *str2) {
  return strcmp(str1, str2) > 0;
}

bool string_ge(char *str1, char *str2) {
  return strcmp(str1, str2) >= 0;
}

bool string_eq(char *str1, char *str2) {
  return strcmp(str1, str2) == 0;
}

bool string_ne(char *str1, char *str2) {
  return strcmp(str1, str2) != 0;
}

char* string_add(char *str1, char *str2) {
  char *str = (char*) malloc((strlen(str1) + strlen(str2) + 1) * sizeof(char));
  sprintf(str, "%s%s", str1, str2);
  return str;
}

void* new_array(int size) {
  void *arr = malloc(sizeof(int) + size);
  *(int*)arr = size;
  return (char*)arr + sizeof(int);
}

int array_size(void* arr) {
  if (arr == 0) {
    return 0;
  }
  return *(int*)((char*)arr - sizeof(int));
}