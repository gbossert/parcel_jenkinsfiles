#!groovy

def call(List<String> paths) {

    echo("Checking if changes occurred in ${paths}")

    build = currentBuild
    while(build != null && build.result != 'SUCCESS') {
	for (changeLog in build.changeSets) {
            for(entry in changeLog.items) {
		for(file in entry.affectedFiles) {
		    for (path in paths) {
			if (file.path.toString().contains(path)) {
			    echo("!! ${file.path}");		    			
			    return true;
			}
			echo(">> ${file.path} (${path})");
		    }
		}
            }
	}
	build = build.previousBuild
    }

    return false;
    
}

return this;

// def has_changed() {
//     def changes = "Changes:\n"
//     build = currentBuild
//     while(build != null && build.result != 'SUCCESS') {
// 	changes += "In ${build.id}:\n"
// 	for (changeLog in build.changeSets) {
//             for(entry in changeLog.items) {
// 		for(file in entry.affectedFiles) {
//                     changes += "* ${file.path}\n"
// 		}
//             }
// 	}
// 	build = build.previousBuild
//     }
//     echo changes
//     return true
// }

// def build() {
//     println("Building service1")
//     sh 'echo "hello U"'
// }

//return this
