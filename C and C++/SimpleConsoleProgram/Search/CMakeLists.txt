PROJECT(MyProject)
CMAKE_MINIMUM_REQUIRED(VERSION 2.8)

SET(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++98")

SET(HDRS search.h) # module headers go here (*.h)
SET(SRCS main.cpp search.cpp) # module implementations go here (*.cpp)

ADD_EXECUTABLE(main ${HDRS} ${SRCS}) # compile and link main executable
