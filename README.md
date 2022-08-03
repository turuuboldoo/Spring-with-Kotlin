# Spring boot with Kotlin and Docker

## OpenJDK
```
sudo apt update
sudo apt install openjdk-11-jdk
```

check your java version
```
java -version
```

## Gradle
Please check latest Gradle version on [gradle.org](https://gradle.org/releases/) 

```
VERSION=7.5
wget https://services.gradle.org/distributions/gradle-${VERSION}-bin.zip -P /tmp
```

Once the download is completed, unzip the file in the /opt/gradle directory:

```
sudo unzip -d /opt/gradle /tmp/gradle-${VERSION}-bin.zip
```

you get an error saying “sudo: unzip: command not found”, install the unzip package with

```
sudo apt install unzip
```

Setting up the Environment Variables

```
export GRADLE_HOME=/opt/gradle/latest
export PATH=${GRADLE_HOME}/bin:${PATH}
```

Verifying the Gradle Installation

```
gradle -v
```

## Docker

First you need docker engine. Documentation on [https://docs.docker.com](https://docs.docker.com/engine/install/ubuntu/)

Update apt package
```
sudo apt-get update
sudo apt-get install \
    ca-certificates \
    curl \
    gnupg \
    lsb-release
```

Add Docker’s official GPG key

```
sudo mkdir -p /etc/apt/keyrings
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
```

Use the following command to set up the repository
```
echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
```

Install Docker Engine
```
sudo apt-get update
sudo apt-get install docker-ce docker-ce-cli containerd.io docker-compose-plugin
```

Receiving a GPG error when running apt-get update. Your default umask may not be set correctly, causing the public key file for the repo to not be detected. Run the following command and then try to update your repo again
```
sudo chmod a+r /etc/apt/keyrings/docker.gpg.
```

Install docker and docker compose
```
sudo apt install docker
sudo apt install docker-compose
```
Check that it’s running:
```
sudo systemctl status docker
```
```
Output
● docker.service - Docker Application Container Engine
     Loaded: loaded (/lib/systemd/system/docker.service; enabled; vendor preset: enabled)
     Active: active (running) since Tue 2020-05-19 17:00:41 UTC; 17s ago
TriggeredBy: ● docker.socket
       Docs: https://docs.docker.com
   Main PID: 24321 (dockerd)
      Tasks: 8
     Memory: 46.4M
     CGroup: /system.slice/docker.service
             └─24321 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock
```

next up git clone and run app from docker
