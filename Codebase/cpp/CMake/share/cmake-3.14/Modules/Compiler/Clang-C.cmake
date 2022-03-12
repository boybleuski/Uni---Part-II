include(Compiler/Clang)
__compiler_clang(C)

cmake_policy(GET CMP0025 appleClangPolicy)
if(APPLE AND NOT appleClangPolicy STREQUAL NEW)
  return()
endif()

if(NOT CMAKE_C_COMPILER_VERSION VERSION_LESS 3.4)
  if(NOT "x${CMAKE_C_SIMULATE_ID}" STREQUAL "xMSVC")
    set(CMAKE_C90_STANDARD_COMPILE_OPTION "-std=c90")
    set(CMAKE_C90_EXTENSION_COMPILE_OPTION "-std=gnu90")

    set(CMAKE_C99_STANDARD_COMPILE_OPTION "-std=c99")
    set(CMAKE_C99_EXTENSION_COMPILE_OPTION "-std=gnu99")

    set(CMAKE_C11_STANDARD_COMPILE_OPTION "-std=c11")
    set(CMAKE_C11_EXTENSION_COMPILE_OPTION "-std=gnu11")
  else()
    # clang-cl doesn't have any of these
    set(CMAKE_C90_STANDARD_COMPILE_OPTION "")
    set(CMAKE_C90_EXTENSION_COMPILE_OPTION "")

    set(CMAKE_C99_STANDARD_COMPILE_OPTION "")
    set(CMAKE_C99_EXTENSION_COMPILE_OPTION "")

    set(CMAKE_C11_STANDARD_COMPILE_OPTION "")
    set(CMAKE_C11_EXTENSION_COMPILE_OPTION "")
  endif()
endif()

if(NOT "x${CMAKE_C_SIMULATE_ID}" STREQUAL "xMSVC")
  __compiler_check_default_language_standard(C 3.4 99 3.6 11)
else()
  set(CMAKE_C_STANDARD_DEFAULT "")
endif()
