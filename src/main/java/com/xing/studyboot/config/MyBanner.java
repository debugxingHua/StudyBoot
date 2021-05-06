package com.xing.studyboot.config;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

public class MyBanner implements Banner{
	
	private static final String BANNER = "               *                                                        &&    \r\n" + 
			"                o:                                                     o&&    \r\n" + 
			"                 &&*                                                  o&o&.   \r\n" + 
			"                 *&&o                                                &&::&.   \r\n" + 
			"                  :&o&&                                            :&o:::&.   \r\n" + 
			"                   :&o:&&o                                       o&&o:::o&    \r\n" + 
			"                    &&ooo&&8.                                  :&&o::oo:&&    \r\n" + 
			"                     &&ooooo88#:                            *&&&ooooooo8&*    \r\n" + 
			"                      o&oooooo&&###&*                   :8&&&ooooooooo&8o     \r\n" + 
			"                       o&oooooo&o&&&8#############88888&ooooooooooooo&#o      \r\n" + 
			"                    *:   :oooooo&:      &&8&&&&&&&&&oooooooooooooo&&8##       \r\n" + 
			"                  *         &o&            &ooooooooooooooooooo&&&&88:        \r\n" + 
			"      .#####:    &     @@8   .              &ooooooooooooo&&&&&&&8@#          \r\n" + 
			"     ##8&&&&@##*o8   8  .8@:        8@@@     &oooooooo&&&&&&&888##*           \r\n" + 
			"    @@888888888@#&:  @@####oo     8@  *#@o   &ooooo&&&&&&&8888##*             \r\n" + 
			"   .@#8888888888@#&&: .&#o8&&.    #@@@@@@&  8&&&&&&&&&&&8888#@8               \r\n" + 
			"   .@#############8&&&&&&&&&&&*    :#@@#*  8&&&&&&&&&&8888##@#                \r\n" + 
			"    @@###########@#8&&&&&&&&&&&&o        8&&&&88&&&&8888###@8                 \r\n" + 
			"     #@@@@@@@@@@@@#888&&&&&&&&&&&&&&&&&&&&&&#8oo8&8888###@#&                  \r\n" + 
			"      #@@@@@@@@@@@#888&&&&&&&&&&&&&&&&&&&&@8&&o:8888######                    \r\n" + 
			"       8@@@@@@@@@##8888&&&&&&&&&&&&&&&&##88&&ooo#8#######                     \r\n" + 
			"         .8@#@@###8888&&&&&&&&&&88#####888&&oooo####@#o                       \r\n" + 
			"             88o&&&888888888#######8888&&&ooo:@###@8*                         \r\n" + 
			"                .#&o&&88888888888&&&&&&&oo:#####8o                            \r\n" + 
			"                       .:&8&ooo:::oo&#@@#@88#:       \r\n";

	@Override
	public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
		out.print(BANNER);		
	}
}
