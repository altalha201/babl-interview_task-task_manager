package com.altalha.babl_interview_task_task_manager.models;

import java.util.ArrayList;

public class UserModel {
    ArrayList<result> results;
    information info;

    public ArrayList<result> getResults() {
        return results;
    }

    public void setResults(ArrayList<result> results) {
        this.results = results;
    }

    public information getInfo() {
        return info;
    }

    public void setInfo(information info) {
        this.info = info;
    }

    public static class result {
        String gender;
        nameObject name;
        locationObject location;
        String email;
        loginData login;
        dateObject dob;
        dateObject registered;
        String phone;
        String cell;
        idObject id;
        pictureObject picture;
        String nat;

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public nameObject getName() {
            return name;
        }

        public void setName(nameObject name) {
            this.name = name;
        }

        public locationObject getLocation() {
            return location;
        }

        public void setLocation(locationObject location) {
            this.location = location;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public loginData getLogin() {
            return login;
        }

        public void setLogin(loginData login) {
            this.login = login;
        }

        public dateObject getDob() {
            return dob;
        }

        public void setDob(dateObject dob) {
            this.dob = dob;
        }

        public dateObject getRegistered() {
            return registered;
        }

        public void setRegistered(dateObject registered) {
            this.registered = registered;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCell() {
            return cell;
        }

        public void setCell(String cell) {
            this.cell = cell;
        }

        public idObject getId() {
            return id;
        }

        public void setId(idObject id) {
            this.id = id;
        }

        public pictureObject getPicture() {
            return picture;
        }

        public void setPicture(pictureObject picture) {
            this.picture = picture;
        }

        public String getNat() {
            return nat;
        }

        public void setNat(String nat) {
            this.nat = nat;
        }

        public static class pictureObject {
            String large;
            String medium;
            String thumbnail;

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }
        }

        public static class idObject {
            String name;
            String value;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        public static class dateObject {
            String date;
            String age;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }
        }

        public static class loginData {
            String uuid;
            String username;
            String password;
            String salt;
            String md5;
            String sha1;
            String sha256;

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getSalt() {
                return salt;
            }

            public void setSalt(String salt) {
                this.salt = salt;
            }

            public String getMd5() {
                return md5;
            }

            public void setMd5(String md5) {
                this.md5 = md5;
            }

            public String getSha1() {
                return sha1;
            }

            public void setSha1(String sha1) {
                this.sha1 = sha1;
            }

            public String getSha256() {
                return sha256;
            }

            public void setSha256(String sha256) {
                this.sha256 = sha256;
            }
        }

        public static class locationObject {
            streetObject street;
            String city;
            String state;
            String country;
            String postcode;
            coordinatesObject coordinates;
            timezoneObject timezone;

            public streetObject getStreet() {
                return street;
            }

            public void setStreet(streetObject street) {
                this.street = street;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getPostcode() {
                return postcode;
            }

            public void setPostcode(String postcode) {
                this.postcode = postcode;
            }

            public coordinatesObject getCoordinates() {
                return coordinates;
            }

            public void setCoordinates(coordinatesObject coordinates) {
                this.coordinates = coordinates;
            }

            public timezoneObject getTimezone() {
                return timezone;
            }

            public void setTimezone(timezoneObject timezone) {
                this.timezone = timezone;
            }

            public static class timezoneObject {
                String offset;
                String description;

                public String getOffset() {
                    return offset;
                }

                public void setOffset(String offset) {
                    this.offset = offset;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }
            }

            public static class coordinatesObject {
                String latitude;
                String longitude;

                public String getLatitude() {
                    return latitude;
                }

                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public String getLongitude() {
                    return longitude;
                }

                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }
            }

            public static class streetObject {
                String number;
                String name;

                public String getNumber() {
                    return number;
                }

                public void setNumber(String number) {
                    this.number = number;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }

        public static class  nameObject{
            String title;
            String first;
            String last;

            public String getFullName() {
                return title + " " + first + " " + last;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getFirst() {
                return first;
            }

            public void setFirst(String first) {
                this.first = first;
            }

            public String getLast() {
                return last;
            }

            public void setLast(String last) {
                this.last = last;
            }
        }
    }

    public static class information{
        String seed;
        String results;
        String page;
        String version;

        public String getSeed() {
            return seed;
        }

        public void setSeed(String seed) {
            this.seed = seed;
        }

        public String getResults() {
            return results;
        }

        public void setResults(String results) {
            this.results = results;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
