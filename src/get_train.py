f = open("train.txt", "w")


lines = open("brown_tagged.txt", "r").readlines()


word_tags = lines[0].replace('./.', './. ').split()
i = 1
for word_tag in word_tags:
    
    if len(word_tag.split('/')) >= 2:
        word = word_tag.split('/')[0]
        tag = word_tag.split('/')[1]

        f.write (str(i) + '\t' + word + '\t' + tag + '\n')
        i += 1

        if word == '.':
            f.write ('\n')
            i = 1
