# python中opencv和websocket并行强制usb资源

# 设备

- jetson nano 2G
- usb摄像头
- usb无线网卡免驱动

# 问题描述

我开了两个进程，一个进程进行图像识别和图像处理，一个进程进行语音识别，但是这两个进行并行启动的时候，发生了摄像头和无线网卡资源抢占的情况。

~~~py
VIDEOIO ERROR: V4L2: Pixel format of incoming image is unsupported by OpenCV Unable to stop the stream: Device or resource busy
~~~

[问题链接](https://askubuntu.com/questions/1049648/videoio-error-v4l2-pixel-format-of-incoming-image-is-unsupported-by-opencv-una)

# 问题分析

在用python的multiprocess 模块时，opencv调用usb摄像头和无线网卡的发送网络请求两个进程发生资源抢占情况，导致摄像头开启报错

# 解决方案

- 思路：取消并行，用python中threading线程模块进行假并行，防止资源抢占
- 解决情况：成功解决问题

